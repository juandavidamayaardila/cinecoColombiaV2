package co.com.sofka.cineco.pelicula;

import co.com.sofka.cineco.pelicula.values.DescripcionIdioma;
import co.com.sofka.cineco.pelicula.values.IdiomaId;
import co.com.sofka.domain.generic.Entity;

public class Idioma extends Entity<IdiomaId> {

    private DescripcionIdioma descripcionIdioma;

    public Idioma(IdiomaId entityId, DescripcionIdioma descripcionIdioma) {
        super(entityId);
        this.descripcionIdioma = descripcionIdioma;
    }

    public DescripcionIdioma getDescripcionIdioma() {
        return descripcionIdioma;
    }

    public void actualizarIdioma(DescripcionIdioma descripcionIdioma) {
        this.descripcionIdioma = descripcionIdioma;
    }
}
