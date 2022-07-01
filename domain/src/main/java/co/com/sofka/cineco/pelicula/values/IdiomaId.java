package co.com.sofka.cineco.pelicula.values;

import co.com.sofka.domain.generic.Identity;

public class IdiomaId extends Identity {

    public IdiomaId() {
    }

    private IdiomaId(String id) {
        super(id);
    }

    public static IdiomaId of(String id) {
        return new IdiomaId(id);
    }

}
