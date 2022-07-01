package co.com.sofka.cineco.pelicula.events;

import co.com.sofka.cineco.pelicula.Estudio;
import co.com.sofka.cineco.pelicula.values.EstudioId;
import co.com.sofka.cineco.pelicula.values.NombreEstudio;
import co.com.sofka.domain.generic.DomainEvent;

public class EstudioAgregado extends DomainEvent {

    private final EstudioId estudioId;
    private final NombreEstudio nombreEstudio;

    public EstudioAgregado(EstudioId entityId, NombreEstudio nombreEstuio) {
        super("co.com.sofka.pelicula.estudioagregado");
        this.estudioId = entityId;
        this.nombreEstudio = nombreEstuio;
    }

    public EstudioId getEstudioId() {
        return estudioId;
    }

    public NombreEstudio getNombreEstudio() {
        return nombreEstudio;
    }
}
