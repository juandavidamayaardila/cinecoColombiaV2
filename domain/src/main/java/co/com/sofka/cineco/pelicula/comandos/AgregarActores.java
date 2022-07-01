package co.com.sofka.cineco.pelicula.comandos;

import co.com.sofka.cineco.pelicula.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarActores extends Command {

    private final PeliculaId peliculaId;


    private final NombreActor nombreActor;
    private final TipoActor tipoActor;

    public AgregarActores(PeliculaId peliculaId,  NombreActor nombreActor, TipoActor tipoActor){
        this.peliculaId = peliculaId;

        this.nombreActor = nombreActor;
        this.tipoActor = tipoActor;
    }



    public TipoActor getTipoActor() {
        return tipoActor;
    }

    public NombreActor getNombreActor() {
        return nombreActor;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }
}
