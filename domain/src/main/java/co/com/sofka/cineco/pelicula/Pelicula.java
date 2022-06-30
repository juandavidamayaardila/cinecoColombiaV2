package co.com.sofka.cineco.pelicula;

import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.pelicula.events.ActualizarHorarioPelicula;
import co.com.sofka.cineco.pelicula.events.PeliculaCreada;
import co.com.sofka.cineco.pelicula.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;

    public class Pelicula extends AggregateEvent<PeliculaId> {

        protected Duracion duracion;
        protected Genero genero;
        protected Horario horario;
        protected Nombre nombre;
        protected Sinopsis sinopsis;

        public Pelicula(PeliculaId entityId, Nombre nombre, Sinopsis sinopsis) {

            super(entityId);
            appendChange(new PeliculaCreada(nombre, sinopsis)).apply();
        }

        private Pelicula(PeliculaId entityId){
            super(entityId);
            subscribe(new PeliculaChange(this));
        }

        public void actualizarSonopsis(Sinopsis sinopsis){
            this.sinopsis = Objects.requireNonNull(sinopsis);
        }

        public void actualizarHorarioPelicula(PeliculaId entityId, Horario horario){
            appendChange(new ActualizarHorarioPelicula(entityId, horario)).apply();
        }
    }
