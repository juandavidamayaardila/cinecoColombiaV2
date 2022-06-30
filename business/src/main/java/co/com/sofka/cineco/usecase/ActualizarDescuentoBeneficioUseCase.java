package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.beneficio.Beneficio;
import co.com.sofka.cineco.beneficio.comandos.ActualizarDescuento;

public class ActualizarDescuentoBeneficioUseCase extends UseCase<RequestCommand<ActualizarDescuento>, ResponseEvents> {


    public void executeUseCase(RequestCommand<ActualizarDescuento> actualizarDescuentoRequestCommand) {

        var command = actualizarDescuentoRequestCommand.getCommand();
        var beneficio = Beneficio.from(
          command.getEntityId(), repository().getEventsBy(command.getEntityId().value())
        );

        beneficio.actualizarDescuento(command.getEntityId(), command.getDescuento());
        emit().onResponse(new ResponseEvents(beneficio.getUncommittedChanges()));

    }
}
