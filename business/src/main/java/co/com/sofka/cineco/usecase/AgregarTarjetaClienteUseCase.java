package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.cliente.Cliente;
import co.com.sofka.cineco.cliente.comandos.AgregarDomicilio;
import co.com.sofka.cineco.cliente.comandos.AgregarTarjeta;

public class AgregarTarjetaClienteUseCase extends UseCase<RequestCommand<AgregarTarjeta>, ResponseEvents> {


    public void executeUseCase(RequestCommand<AgregarTarjeta> agregarTarjetaRequestCommand) {
        var command = agregarTarjetaRequestCommand.getCommand();
        var cliente = Cliente.from(command.getEntityId(), repository()
                .getEventsBy(command.getEntityId().value()));

        cliente.agregarTarjeta(command.getTarjetaCinecoId() );
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
