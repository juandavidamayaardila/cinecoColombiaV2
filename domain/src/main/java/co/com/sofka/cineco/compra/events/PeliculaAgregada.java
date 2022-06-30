package co.com.sofka.cineco.compra.events;

import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.cineco.pelicula.values.Sinopsis;
import co.com.sofka.domain.generic.DomainEvent;

public class PeliculaAgregada extends DomainEvent {

    private final PeliculaId entityId;

    private  final Nombre nombre;

    private  final Sinopsis sinopsis;
    public PeliculaAgregada(PeliculaId entityId, Nombre nombre, Sinopsis sinopsis) {
        super("sofka.cliente.peliculaagregada");

        this.entityId = entityId;
        this.nombre = nombre;
        this.sinopsis = sinopsis;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Sinopsis getSinopsis() {
        return sinopsis;
    }

    public PeliculaId getEntityId() {
        return entityId;
    }
}
