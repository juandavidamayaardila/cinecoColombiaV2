package co.com.sofka.cineco.compra;

import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.compra.events.AsientoAgregado;
import co.com.sofka.cineco.compra.events.CompraRealizada;
import co.com.sofka.cineco.compra.events.FechaActualizada;
import co.com.sofka.cineco.compra.events.PeliculaAgregada;
import co.com.sofka.cineco.compra.values.CompraId;
import co.com.sofka.cineco.compra.values.Fecha;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.cineco.pelicula.values.Sinopsis;
import co.com.sofka.cineco.sala.Asiento;
import co.com.sofka.cineco.sala.values.AsientoId;
import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Compra extends AggregateEvent<CompraId> {
    protected Fecha fecha;
    protected IdentificacionCliente clienteid;
    protected PeliculaId peliculaId;

    protected Set<Asiento> asientos;

    public Compra(CompraId entityId, IdentificacionCliente clienteid, Fecha fecha) {
        super(entityId);

        appendChange(new CompraRealizada(clienteid, fecha)).apply();
    }

    /**
     * Constructor privado que permite aplicar los cambios,
     * cambiar los estados.
     *
     * @param entityId
     */
    private Compra(CompraId entityId){
        super(entityId);
        subscribe(new CompraChange(this));
    }

    /**
     * Permite aplicar los eventos en orden el primero que se ejecuta
     * es crear.
     *
     * @param compraId
     * @param events
     * @return
     */
    public static Compra from(CompraId compraId, List<DomainEvent> events){
        var compra = new Compra(compraId);
        events.forEach(compra::applyEvent);
        return compra;
    }

    public void agregarAsiento(AsientoId entityId, Descripcion descripcion){
        Objects.requireNonNull(entityId);
        appendChange(new AsientoAgregado(entityId, descripcion)).apply();
    }

    public void agregarPelicula(PeliculaId entityId, Nombre nombre, Sinopsis sinopsis){
        appendChange(new PeliculaAgregada(entityId, nombre, sinopsis));
    }

    public void actualizarFechaCompra(CompraId compraId, Fecha fecha){
        appendChange(new FechaActualizada(compraId, fecha)).apply();
    }

    public Optional<Asiento> getAsientoPorId(AsientoId entityId){
        return asientos
                .stream()
                .filter(asiento -> asiento.identity().equals(entityId))
                .findFirst();
    }

    public Set<Asiento> asientos() {
        return asientos;
    }

    public PeliculaId peliculaId() {
        return peliculaId;
    }

    public IdentificacionCliente clienteid() {
        return clienteid;
    }

    public Fecha fecha() {
        return fecha;
    }
}
