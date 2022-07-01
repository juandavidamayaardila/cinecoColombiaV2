package co.com.sofka.cineco.pelicula;

import co.com.sofka.cineco.pelicula.values.EstudioId;
import co.com.sofka.cineco.pelicula.values.NombreEstudio;
import co.com.sofka.domain.generic.Entity;

public class Estudio extends Entity<EstudioId> {

    protected NombreEstudio nombreEstudio;

    public Estudio(EstudioId entityId, NombreEstudio nombreEstuio) {
        super(entityId);
        this.nombreEstudio = nombreEstuio;
    }

    public NombreEstudio nombreEstudio() {
        return nombreEstudio;
    }

    public void actualizarNombreEstudio(NombreEstudio nombre) {
        this.nombreEstudio = nombre;
    }
}
