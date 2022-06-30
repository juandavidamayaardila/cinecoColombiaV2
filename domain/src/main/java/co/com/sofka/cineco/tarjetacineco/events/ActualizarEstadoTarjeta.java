package co.com.sofka.cineco.tarjetacineco.events;

import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.DomainEvent;

public class ActualizarEstadoTarjeta extends DomainEvent {

    private final TarjetaCinecoId entityId;
    private final Estado estado;

    public ActualizarEstadoTarjeta(TarjetaCinecoId entityId, Estado estado) {
        super("sofka.tarjeta.estadoactualizado");

        this.entityId = entityId;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public TarjetaCinecoId getEntityId() {
        return entityId;
    }
}
