package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.sala.Sala;
import co.com.sofka.cineco.sala.comandos.CrearSala;
import co.com.sofka.cineco.sala.values.AsientoId;
import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.cineco.sala.values.SalaId;
import co.com.sofka.cineco.sala.values.TipoSala;

public class CrearSalaUseCase extends UseCase<RequestCommand<CrearSala>, ResponseEvents> {

    public void executeUseCase(RequestCommand<CrearSala> crearSalaRequestCommand) {
        var command = crearSalaRequestCommand.getCommand();
        var sala = new Sala(
                new SalaId(),
                command.getTipoSala(),
                command.getAsientos()

        );

        emit().onResponse(new ResponseEvents(sala.getUncommittedChanges()));
    }
}
