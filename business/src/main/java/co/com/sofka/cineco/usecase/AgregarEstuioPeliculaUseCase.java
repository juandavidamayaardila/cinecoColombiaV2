package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.pelicula.Estudio;
import co.com.sofka.cineco.pelicula.Pelicula;
import co.com.sofka.cineco.pelicula.comandos.AgregarEstudio;
import co.com.sofka.cineco.pelicula.comandos.CrearPelicula;
import co.com.sofka.cineco.pelicula.values.EstudioId;
import co.com.sofka.cineco.pelicula.values.PeliculaId;

public class AgregarEstuioPeliculaUseCase extends UseCase<RequestCommand<AgregarEstudio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarEstudio> agregarEstudioRequestCommand) {
        var command = agregarEstudioRequestCommand.getCommand();

        var pelicula = Pelicula.from(
                command.getPeliculaId(), repository().getEventsBy(command.getPeliculaId().value())
        );
        pelicula.agregarEstudio(command.getNombreEstudio());
        emit().onResponse(new ResponseEvents(pelicula.getUncommittedChanges()));
    }
}
