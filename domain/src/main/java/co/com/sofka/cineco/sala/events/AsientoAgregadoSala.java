package co.com.sofka.cineco.sala.events;

import co.com.sofka.cineco.sala.values.AsientoId;
import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class AsientoAgregadoSala extends DomainEvent {

    private final AsientoId entityId;
    private final Descripcion descripcion;

    public AsientoAgregadoSala(AsientoId entityId, Descripcion descripcion) {

        super("sofka.cliente.asientoagregadosala");
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
