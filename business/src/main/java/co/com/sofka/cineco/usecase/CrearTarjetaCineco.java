package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.tarjetacineco.TarjetaCineco;
import co.com.sofka.cineco.tarjetacineco.comandos.CrearTarjeta;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;

public class CrearTarjetaCineco extends UseCase<RequestCommand<CrearTarjeta>, ResponseEvents> {

    public void executeUseCase(RequestCommand<CrearTarjeta> crearTarjetaRequestCommand) {
        var command = crearTarjetaRequestCommand.getCommand();
        var tarjeta = new TarjetaCineco(
                new TarjetaCinecoId(),
                command.getDescripcion(),
                command.getEstado(),
                command.getBeneficioList()
        );

        emit().onResponse(new ResponseEvents(tarjeta.getUncommittedChanges()));
    }


}
