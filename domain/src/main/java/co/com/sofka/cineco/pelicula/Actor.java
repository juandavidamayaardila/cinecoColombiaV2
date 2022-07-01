package co.com.sofka.cineco.pelicula;

import co.com.sofka.cineco.pelicula.values.ActorId;
import co.com.sofka.cineco.pelicula.values.NombreActor;
import co.com.sofka.cineco.pelicula.values.TipoActor;
import co.com.sofka.domain.generic.Entity;

public class Actor extends Entity<ActorId> {

    
    private NombreActor  nombreActor;
    private TipoActor tipoActor;
    public Actor(ActorId entityId,NombreActor nombreActor, TipoActor tipoActor ){
        super(entityId);
        this.entityId = entityId;
        this.nombreActor = nombreActor;
        this.tipoActor = tipoActor;
    }
    
    public void actualizarTipoActor(TipoActor tipoActor){
        this.tipoActor = tipoActor;
    }
    public NombreActor nombreActor() {
        return nombreActor;
    }

    public TipoActor tipoActor() {
        return tipoActor;
    }
}
