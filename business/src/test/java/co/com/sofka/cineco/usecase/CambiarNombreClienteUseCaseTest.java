package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.cliente.comandos.CambiarNombre;
import co.com.sofka.cineco.cliente.comandos.CrearCliente;
import co.com.sofka.cineco.cliente.events.ClienteCreado;
import co.com.sofka.cineco.cliente.events.NombreCambiado;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarNombreClienteUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarNombreClienteUseCase usecase;

    @Test
    public void cambiarNombreCliente() {

        IdentificacionCliente entityId = IdentificacionCliente.of(IdentificacionCliente.Type.CC, "1094");
        Nombre nombre = new Nombre("juan");

        var command = new CambiarNombre(entityId, nombre);

        when(repository.getEventsBy(entityId.value())).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (NombreCambiado) events.get(0);
        Assertions.assertEquals("juan", event.getNombre().value());

    }

    private List<DomainEvent> history() {
        Nombre nombre = new Nombre("David");
        Email email = new Email("juan@gmail.com");
        return List.of(
                new ClienteCreado(nombre, email)
        );
    }
}