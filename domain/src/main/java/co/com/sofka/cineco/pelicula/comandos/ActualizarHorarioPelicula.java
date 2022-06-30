package co.com.sofka.cineco.pelicula.comandos;

import co.com.sofka.cineco.pelicula.values.Horario;
import co.com.sofka.cineco.pelicula.values.PeliculaId;

public class ActualizarHorarioPelicula {

    private final PeliculaId entityId;
    private final Horario horario;

    public ActualizarHorarioPelicula(PeliculaId entityId, Horario horario){
        this.entityId = entityId;
        this.horario = horario;
    }

    public Horario getHorario() {
        return horario;
    }

    public PeliculaId getEntityId() {
        return entityId;
    }
}
