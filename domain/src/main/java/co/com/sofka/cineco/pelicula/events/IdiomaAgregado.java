package co.com.sofka.cineco.pelicula.events;

import co.com.sofka.cineco.pelicula.values.DescripcionIdioma;
import co.com.sofka.cineco.pelicula.values.IdiomaId;
import co.com.sofka.domain.generic.DomainEvent;

public class IdiomaAgregado extends DomainEvent {

    private final IdiomaId idiomaId;
    private final DescripcionIdioma descripcionIdioma;

    public IdiomaAgregado(IdiomaId entityId, DescripcionIdioma descripcionIdioma) {
        super("sofka.pelicula.idiomaagregado");
        this.idiomaId = entityId;
        this.descripcionIdioma = descripcionIdioma;
    }

    public DescripcionIdioma getDescripcionIdioma() {
        return descripcionIdioma;
    }

    public IdiomaId getIdiomaId() {
        return idiomaId;
    }
}
