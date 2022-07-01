package co.com.sofka.cineco.pelicula.values;

import co.com.sofka.cineco.cliente.values.PreferenciaId;
import co.com.sofka.domain.generic.Identity;

public class EstudioId extends Identity {

    public EstudioId() {
    }

    private EstudioId(String id) {
        super(id);
    }

    public static EstudioId of(String id) {
        return new EstudioId(id);
    }

}
