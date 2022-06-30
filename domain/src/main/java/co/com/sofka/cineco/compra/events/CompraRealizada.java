package co.com.sofka.cineco.compra.events;

import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.compra.values.Fecha;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class CompraRealizada extends DomainEvent {

    protected IdentificacionCliente clienteid;
    protected PeliculaId peliculaId;
    protected Fecha fecha;
    public CompraRealizada(IdentificacionCliente clienteid,  Fecha fecha) {
        super("sofka.beenficio.beneficiocreado");

        this.clienteid = clienteid;
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public IdentificacionCliente getClienteid() {
        return clienteid;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }
}
