package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.cliente.Cliente;
import co.com.sofka.cineco.cliente.comandos.CambiarEmail;


public class CambiarEmailClienteUseCase extends UseCase<RequestCommand<CambiarEmail>, ResponseEvents> {

    public void executeUseCase(RequestCommand<CambiarEmail> cambiarEmailRequestCommand) {
        var command = cambiarEmailRequestCommand.getCommand();
        var cliente = Cliente.from(command.getEntityId(), repository()
                .getEventsBy(command.getEntityId().value()));

        cliente.cambiarEmail(command.getEntityId(), command.getEmail());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
