package co.com.sofka.cineco.cliente.events;

import co.com.sofka.cineco.cliente.values.Domicilio;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.domain.generic.DomainEvent;

public class DomicilioAgregado extends DomainEvent {

    private final IdentificacionCliente entityId;
    private final Domicilio domicilio;

    public DomicilioAgregado(IdentificacionCliente entityId, Domicilio domicilio) {
        super("sofka.cliente.domiciliocambiado");
        this.entityId = entityId;
        this.domicilio = domicilio;

    }

    public IdentificacionCliente getEntityId() {
        return entityId;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }
}
