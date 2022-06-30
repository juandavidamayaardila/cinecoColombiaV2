package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.pelicula.Pelicula;
import co.com.sofka.cineco.pelicula.comandos.CrearPelicula;
import co.com.sofka.cineco.pelicula.values.PeliculaId;

public class CrearPeliculaUseCase extends UseCase<RequestCommand<CrearPelicula>, ResponseEvents> {



    public void executeUseCase(RequestCommand<CrearPelicula> crearPeliculaRequestCommand) {
        var command = crearPeliculaRequestCommand.getCommand();
        var pelicula = new Pelicula(
                new PeliculaId(),
                command.getNombre(),
                command.getSinopsis()
        );
        emit().onResponse(new ResponseEvents(pelicula.getUncommittedChanges()));
    }
}
