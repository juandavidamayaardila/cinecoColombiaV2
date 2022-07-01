package co.com.sofka.cineco.pelicula.values;

import co.com.sofka.cineco.cliente.values.PreferenciaId;
import co.com.sofka.domain.generic.Identity;

public class ActorId extends Identity {

    public ActorId() {
    }

    private ActorId(String id) {
        super(id);
    }

    public static ActorId of(String id) {
        return new ActorId(id);
    }


}