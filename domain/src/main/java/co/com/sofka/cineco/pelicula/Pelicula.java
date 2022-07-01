package co.com.sofka.cineco.pelicula;

import co.com.sofka.cineco.cliente.Cliente;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.pelicula.events.*;
import co.com.sofka.cineco.pelicula.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Pelicula extends AggregateEvent<PeliculaId> {

    protected Duracion duracion;
    protected Genero genero;
    protected Horario horario;
    protected NombrePelicula nombre;
    protected Sinopsis sinopsis;

    protected Set<Actor> actores;
    protected Set<Idioma> idiomas;
    protected Estudio estudio;

    public Pelicula(PeliculaId entityId, NombrePelicula nombre, Sinopsis sinopsis) {

        super(entityId);
        appendChange(new PeliculaCreada(nombre, sinopsis)).apply();
        subscribe(new PeliculaChange(this));
    }

    private Pelicula(PeliculaId entityId) {
        super(entityId);
        subscribe(new PeliculaChange(this));
    }

    public static Pelicula from(PeliculaId entityId, List<DomainEvent> eventsBy) {
        var pelicula = new Pelicula(entityId);
        eventsBy.forEach(pelicula::applyEvent);
        return pelicula;
    }

    public void actualizarSonopsis(Sinopsis sinopsis) {
        this.sinopsis = Objects.requireNonNull(sinopsis);
    }

    public void actualizarHorarioPelicula(PeliculaId entityId, Horario horario) {
        appendChange(new ActualizarHorarioPelicula(entityId, horario)).apply();
    }

    public void agregarActores(NombreActor nombreActor, TipoActor tipoActor) {
        var entityId = new ActorId();
        appendChange(new ActoresAgregados(entityId, nombreActor, tipoActor)).apply();
    }

    public void agregarIdiomas(IdiomaId entityId, DescripcionIdioma descripcionIdioma) {
        appendChange(new IdiomaAgregado(entityId, descripcionIdioma)).apply();
    }

    public void agregarEstudio(NombreEstudio nombreEstuio) {
        var entityId = new EstudioId();
        appendChange(new EstudioAgregado(entityId, nombreEstuio)).apply();
    }

    public NombrePelicula nombre() {
        return nombre;
    }

    public Sinopsis sinopsis() {
        return sinopsis;
    }

    public Estudio estudio() {
        return estudio;
    }
}
