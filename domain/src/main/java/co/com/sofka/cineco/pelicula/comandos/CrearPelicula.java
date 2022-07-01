package co.com.sofka.cineco.pelicula.comandos;

import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.pelicula.Pelicula;
import co.com.sofka.cineco.pelicula.values.NombrePelicula;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.cineco.pelicula.values.Sinopsis;
import co.com.sofka.domain.generic.Command;

public class CrearPelicula extends Command {

  //  private final PeliculaId entityId;
    private final NombrePelicula nombre;
    private final Sinopsis sinopsis;

    public CrearPelicula( NombrePelicula nombre, Sinopsis sinopsis){
       // this.entityId = entityId;
        this.nombre = nombre;
        this.sinopsis = sinopsis;
    }

    /*public PeliculaId getEntityId() {
        return entityId;
    }*/

    public NombrePelicula getNombre() {
        return nombre;
    }

    public Sinopsis getSinopsis() {
        return sinopsis;
    }
}
