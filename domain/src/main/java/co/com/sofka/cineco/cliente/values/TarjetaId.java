package co.com.sofka.cineco.cliente.values;

import co.com.sofka.cineco.pelicula.values.EstudioId;
import co.com.sofka.domain.generic.Identity;

public class TarjetaId extends Identity {

    public TarjetaId() {
    }

    private TarjetaId(String id) {
        super(id);
    }

    public static TarjetaId of(String id) {
        return new TarjetaId(id);
    }
}
