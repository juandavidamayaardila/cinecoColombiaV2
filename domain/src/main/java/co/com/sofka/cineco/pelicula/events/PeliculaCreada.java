package co.com.sofka.cineco.pelicula.events;

import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.pelicula.values.Horario;
import co.com.sofka.cineco.pelicula.values.NombrePelicula;
import co.com.sofka.cineco.pelicula.values.Sinopsis;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class PeliculaCreada extends DomainEvent {

    protected NombrePelicula nombre;
    protected Sinopsis sinopsis;
    protected Horario horario;

    public PeliculaCreada(NombrePelicula nombre, Sinopsis sinopsis) {
        super("sofka.pelicula.peliculacreado");
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.horario = null;
    }

    public NombrePelicula getNombre() {
        return nombre;
    }

    public Sinopsis getSinopsis() {
        return sinopsis;
    }
}
