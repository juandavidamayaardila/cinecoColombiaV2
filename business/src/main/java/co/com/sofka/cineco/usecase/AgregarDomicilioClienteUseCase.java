package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.cliente.Cliente;
import co.com.sofka.cineco.cliente.comandos.AgregarDomicilio;

public class AgregarDomicilioClienteUseCase extends UseCase<RequestCommand<AgregarDomicilio>, ResponseEvents> {

    public void executeUseCase(RequestCommand<AgregarDomicilio> cambiarDomicilioRequestCommand) {
        var command = cambiarDomicilioRequestCommand.getCommand();
        var cliente = Cliente.from(command.getEntityId(), repository()
                .getEventsBy(command.getEntityId().value()));

        cliente.agregarDomicilio(command.getEntityId(), command.getDomicilio());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
