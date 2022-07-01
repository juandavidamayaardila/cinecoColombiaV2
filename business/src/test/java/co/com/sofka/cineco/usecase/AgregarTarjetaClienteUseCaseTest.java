package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.cliente.Cliente;
import co.com.sofka.cineco.cliente.comandos.AgregarDomicilio;
import co.com.sofka.cineco.cliente.comandos.AgregarTarjeta;
import co.com.sofka.cineco.cliente.events.ClienteCreado;
import co.com.sofka.cineco.cliente.events.DomicilioAgregado;
import co.com.sofka.cineco.cliente.events.TarjetaAgregada;
import co.com.sofka.cineco.cliente.values.Domicilio;
import co.com.sofka.cineco.cliente.values.Email;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.tarjetacineco.TarjetaCineco;
import co.com.sofka.cineco.tarjetacineco.comandos.CrearTarjeta;
import co.com.sofka.cineco.tarjetacineco.values.Beneficio;
import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarTarjetaClienteUseCaseTest {

    @Mock
    DomainEventRepository repository;
    @InjectMocks
    AgregarTarjetaClienteUseCase usecase;

    @Test
    public void agregarTarjetaCliente() {
        IdentificacionCliente entityId = IdentificacionCliente.of(IdentificacionCliente.Type.CC, "1094");
        TarjetaCinecoId tarjetaId  = TarjetaCinecoId.of("321");

        var command = new AgregarTarjeta(entityId, tarjetaId);

        when(repository.getEventsBy("1094")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TarjetaAgregada)events.get(0);
        Assertions.assertEquals("321", event.getEntityId());
    }

    private List<DomainEvent> history() {
        Nombre nombre = new Nombre("David");
        Email email = new Email("juan@gmail.com");
        return List.of(
                new ClienteCreado(nombre, email)
        );
    }

}