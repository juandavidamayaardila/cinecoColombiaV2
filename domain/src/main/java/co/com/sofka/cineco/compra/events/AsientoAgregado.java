package co.com.sofka.cineco.compra.events;

import co.com.sofka.cineco.sala.values.AsientoId;
import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class AsientoAgregado extends DomainEvent {

    private final AsientoId entityId;
    private final Descripcion descripcion;
    public AsientoAgregado(AsientoId entityId, Descripcion descripcion) {

        super("sofka.cliente.asientoagregado");
        this.entityId = entityId;
        this.descripcion = descripcion;
    }

    public AsientoId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
