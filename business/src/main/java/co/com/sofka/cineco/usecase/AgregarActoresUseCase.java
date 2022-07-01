package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cineco.pelicula.Pelicula;
import co.com.sofka.cineco.pelicula.comandos.AgregarActores;
import co.com.sofka.cineco.pelicula.comandos.AgregarEstudio;

public class AgregarActoresUseCase extends UseCase<RequestCommand<AgregarActores>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarActores> agregarActoresRequestCommand) {
        var command = agregarActoresRequestCommand.getCommand();
        var pelicula = Pelicula.from(
                command.getPeliculaId(), repository().getEventsBy(command.getPeliculaId().value())
        );
        pelicula.agregarActores(command.getNombreActor(), command.getTipoActor());
        emit().onResponse(new ResponseEvents(pelicula.getUncommittedChanges()));
    }
}
