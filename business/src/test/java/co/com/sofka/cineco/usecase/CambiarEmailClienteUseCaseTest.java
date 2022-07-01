package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.cliente.comandos.CambiarEmail;
import co.com.sofka.cineco.cliente.comandos.CambiarNombre;
import co.com.sofka.cineco.cliente.events.ClienteCreado;
import co.com.sofka.cineco.cliente.events.EmailCambiado;
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
class CambiarEmailClienteUseCaseTest {

    @Mock
    DomainEventRepository repository;
    @InjectMocks
    CambiarEmailClienteUseCase usecase;

    @Test
    public void cambiarEmailCliente() {
        IdentificacionCliente entityId = IdentificacionCliente.of(IdentificacionCliente.Type.CC, "1094");
        Nombre nombre = new Nombre("juan");
        Email email = new Email("david@gmail.com");

        var command = new CambiarEmail(entityId, email);

        when(repository.getEventsBy(entityId.value())).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EmailCambiado) events.get(0);
        Assertions.assertEquals("david@gmail.com", event.getEmail().value());
        Assertions.assertEquals("CC-1094", event.getEntityId().value());

    }

    private List<DomainEvent> history() {
        Nombre nombre = new Nombre("David");
        Email email = new Email("juan@gmail.com");
        return List.of(
                new ClienteCreado(nombre, email)
        );
    }
}