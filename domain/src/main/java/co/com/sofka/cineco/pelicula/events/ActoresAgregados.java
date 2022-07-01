package co.com.sofka.cineco.pelicula.events;

import co.com.sofka.cineco.pelicula.values.ActorId;
import co.com.sofka.cineco.pelicula.values.NombreActor;
import co.com.sofka.cineco.pelicula.values.TipoActor;
import co.com.sofka.domain.generic.DomainEvent;

public class ActoresAgregados extends DomainEvent {

    private  final ActorId actorId;
    private final NombreActor nombreActor;
    private final TipoActor tipoActor;

    public ActoresAgregados(ActorId entityId, NombreActor nombreActor, TipoActor tipoActor) {
        super("sofka.pelicula.actoragregado");

        this.actorId = entityId;
        this.nombreActor = nombreActor;
        this.tipoActor = tipoActor;

    }

    public NombreActor getNombreActor() {
        return nombreActor;
    }

    public ActorId getActorId() {
        return actorId;
    }

    public TipoActor getTipoActor() {
        return tipoActor;
    }
}
