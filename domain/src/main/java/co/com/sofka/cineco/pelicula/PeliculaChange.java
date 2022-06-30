package co.com.sofka.cineco.pelicula;

import co.com.sofka.cineco.pelicula.events.ActualizarHorarioPelicula;
import co.com.sofka.cineco.pelicula.events.PeliculaCreada;
import co.com.sofka.domain.generic.EventChange;

public class PeliculaChange extends EventChange {


    public PeliculaChange(Pelicula pelicula) {

        apply((PeliculaCreada events) ->{
            pelicula.nombre = events.getNombre();
            pelicula.sinopsis = events.getSinopsis();
        });

        apply((ActualizarHorarioPelicula event) ->{
            pelicula.horario = event.getHorario();
        });
    }
}
