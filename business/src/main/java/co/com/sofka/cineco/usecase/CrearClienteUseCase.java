package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.cliente.Cliente;
import co.com.sofka.cineco.cliente.comandos.CrearCliente;
import co.com.sofka.cineco.cliente.values.Email;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.cliente.values.Nombre;


public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {

    public void executeUseCase(RequestCommand<CrearCliente> crearClienteComandRequestCommand){
        var comand = crearClienteComandRequestCommand.getCommand();
        var cliente = new Cliente(
                comand.getEntityId(),
                comand.getNombre(),
                comand.getEmail()
        );
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
