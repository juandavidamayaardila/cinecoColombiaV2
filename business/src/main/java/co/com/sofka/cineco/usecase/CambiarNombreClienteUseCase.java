package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.cliente.Cliente;
import co.com.sofka.cineco.cliente.comandos.CambiarNombre;

public class CambiarNombreClienteUseCase extends UseCase<RequestCommand<CambiarNombre>, ResponseEvents> {



    public void executeUseCase(RequestCommand<CambiarNombre> cambiarNombreRequestCommand) {
        var command = cambiarNombreRequestCommand.getCommand();
        var cliente = Cliente.from(command.getEntityId(), repository()
                .getEventsBy(command.getEntityId().value()));

        cliente.cambiarNombre(command.getEntityId(), command.getNombre());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
