package co.com.sofka.cineco.cliente.events;

import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.DomainEvent;

public class TarjetaAgregadaCliente extends DomainEvent {

    private final TarjetaCinecoId entityId;
    private final Descripcion descripcion;
    private final Estado estado;
    public TarjetaAgregadaCliente(TarjetaCinecoId entityId, Descripcion descripcion, Estado estado) {
        super("sofka.cliente.tarjetaagregada");
        this.entityId = entityId;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public TarjetaCinecoId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }
}
