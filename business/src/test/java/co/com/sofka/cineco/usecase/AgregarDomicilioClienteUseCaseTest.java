package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.cliente.Cliente;
import co.com.sofka.cineco.cliente.comandos.AgregarDomicilio;
import co.com.sofka.cineco.cliente.events.ClienteCreado;
import co.com.sofka.cineco.cliente.events.DomicilioAgregado;
import co.com.sofka.cineco.cliente.values.Domicilio;
import co.com.sofka.cineco.cliente.values.Email;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarDomicilioClienteUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarDomicilioClienteUseCase usecase;

    @Test
    public void agregarDomicilioCliente() {

        IdentificacionCliente entityId = IdentificacionCliente.of(IdentificacionCliente.Type.CC, "1094");
        Nombre nombre = new Nombre("juan");
        Email email = new Email("juan@gmail.com");

        Domicilio domicilio = new Domicilio("Modelo Mz B casa 19");

        Cliente cliente = new Cliente(entityId, nombre, email);

        var command = new AgregarDomicilio(entityId, domicilio);

        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DomicilioAgregado) events.get(0);
        Assertions.assertEquals("Modelo Mz B casa 19", event.getDomicilio().value());

    }


}