package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.cineco.cliente.events.NombreCambiado;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.cliente.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotificarCambioNombreClienteUseCaseTest {

    @InjectMocks
    private NotificarCambioNombreClienteUseCase useCase;

    @Mock
    private EmailService service;

    @Test
    void enviarCorreoActualizacionNombre() {

        var event = new NombreCambiado(IdentificacionCliente.of("CC-1094"), new Nombre("TOM CRUZ"));

        Mockito.doNothing().when(service).enviarCorreo(IdentificacionCliente.of("CC-1094"), "Su nombre cambio exitosamente ahora es TOM CRUZ");

        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Mockito.verify(service).enviarCorreo(IdentificacionCliente.of("CC-1094"),
                "Su nombre cambio exitosamente ahora es TOM CRUZ");

        Assertions.assertEquals(0, events.size());

    }

}