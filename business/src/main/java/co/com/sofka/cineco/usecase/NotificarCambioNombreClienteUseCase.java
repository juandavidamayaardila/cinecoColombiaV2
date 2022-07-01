package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.cineco.cliente.Cliente;
import co.com.sofka.cineco.cliente.events.NombreCambiado;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;

import java.util.List;

public class NotificarCambioNombreClienteUseCase extends UseCase<TriggeredEvent<NombreCambiado>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<NombreCambiado> nombreCambiadoTriggeredEvent) {
        var event = nombreCambiadoTriggeredEvent.getDomainEvent();

        var body = String.format("Su nombre cambio exitosamente ahora es %s", event.getNombre().value());
        var service = getService(EmailService.class).orElseThrow();
        service.enviarCorreo(event.getEntityId(), body);

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
