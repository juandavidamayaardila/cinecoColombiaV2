package co.com.sofka.cineco.pelicula.events;

import co.com.sofka.cineco.pelicula.Pelicula;
import co.com.sofka.cineco.pelicula.values.Horario;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ActualizarHorarioPelicula extends DomainEvent {

    private final PeliculaId entityId;
    private final Horario horario;
    public ActualizarHorarioPelicula(PeliculaId entityId, Horario horario) {
        super("sofka.horario.horarioactualizado");

        this.entityId = entityId;
        this.horario = horario;
    }

    public PeliculaId getEntityId() {
        return entityId;
    }

    public Horario getHorario() {
        return horario;
    }
}
