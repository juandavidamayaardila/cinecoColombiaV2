package co.com.sofka.cineco.compra.events;

import co.com.sofka.cineco.compra.values.CompraId;
import co.com.sofka.cineco.compra.values.Fecha;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaActualizada extends DomainEvent {

    private final CompraId entityId;
    private final Fecha fecha;
    public FechaActualizada(CompraId entityId, Fecha fecha) {
        super("sofka.compra.fechacompraactualizada");

        this.entityId = entityId;
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public CompraId entityId() {
        return entityId;
    }
}
