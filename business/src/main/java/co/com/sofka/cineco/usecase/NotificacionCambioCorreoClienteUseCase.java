package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.cineco.cliente.events.EmailCambiado;

import java.util.List;

public class NotificacionCambioCorreoClienteUseCase extends UseCase<TriggeredEvent<EmailCambiado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<EmailCambiado> emailCambiadoTriggeredEvent) {
        var event = emailCambiadoTriggeredEvent.getDomainEvent();


        var body = String.format("Su correo a cambio exitosamente, ahora es %s", event.getEmail().value());
        var service = getService(EmailService.class).orElseThrow();
        service.enviarCorreo(event.getEntityId(), body);

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
