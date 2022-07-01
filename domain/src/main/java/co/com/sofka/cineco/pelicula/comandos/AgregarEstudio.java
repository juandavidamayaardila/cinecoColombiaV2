package co.com.sofka.cineco.pelicula.comandos;

import co.com.sofka.cineco.cliente.comandos.AgregarPreferencias;
import co.com.sofka.cineco.pelicula.values.EstudioId;
import co.com.sofka.cineco.pelicula.values.NombreEstudio;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.cineco.pelicula.values.Sinopsis;
import co.com.sofka.domain.generic.Command;

public class AgregarEstudio extends Command {

    private final PeliculaId peliculaId;

    private final NombreEstudio nombreEstudio;

    public AgregarEstudio(PeliculaId peliculaId,  NombreEstudio nombreEstuio) {
        this.peliculaId = peliculaId;
        this.nombreEstudio = nombreEstuio;
    }

    public NombreEstudio getNombreEstudio() {
        return nombreEstudio;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }
}
