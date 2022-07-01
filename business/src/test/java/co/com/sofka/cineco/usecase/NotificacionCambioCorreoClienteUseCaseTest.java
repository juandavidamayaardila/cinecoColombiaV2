package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.cineco.cliente.events.EmailCambiado;
import co.com.sofka.cineco.cliente.events.NombreCambiado;
import co.com.sofka.cineco.cliente.values.Email;
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
class NotificacionCambioCorreoClienteUseCaseTest {

    @InjectMocks
    private NotificacionCambioCorreoClienteUseCase useCase;

    @Mock
    private EmailService service;

    @Test
    void enviarCorreoActualizacionCorreo(){

        var event = new EmailCambiado(IdentificacionCliente.of("CC-1094"), new Email("aleja@gmail.com"));

        Mockito.doNothing().when(service).enviarCorreo(IdentificacionCliente.of("CC-1094"),"Su correo a cambio exitosamente, ahora es aleja@gmail.com");
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Mockito.verify(service).enviarCorreo(IdentificacionCliente.of("CC-1094"),
                "Su correo a cambio exitosamente, ahora es aleja@gmail.com");

        Assertions.assertEquals(0,events.size());
    }
}