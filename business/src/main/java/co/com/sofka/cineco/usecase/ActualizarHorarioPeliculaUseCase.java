package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.pelicula.Pelicula;
import co.com.sofka.cineco.pelicula.comandos.ActualizarHorarioPelicula;

public class ActualizarHorarioPeliculaUseCase extends UseCase<RequestCommand<ActualizarHorarioPelicula>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarHorarioPelicula> actualizarHorarioPeliculaRequestCommand) {
        var command = actualizarHorarioPeliculaRequestCommand.getCommand();
        var pelicula =  Pelicula.from(command.getEntityId(), repository()
                .getEventsBy(command.getEntityId().value()));

        pelicula.actualizarHorarioPelicula(command.getEntityId(), command.getHorario());
        emit().onResponse(new ResponseEvents(pelicula.getUncommittedChanges()));
    }
}
