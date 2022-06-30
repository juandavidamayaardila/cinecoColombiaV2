package co.com.sofka.cineco.cliente.events;

import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreCambiado extends DomainEvent {

    private final IdentificacionCliente entityId;
    private final Nombre nombre;

    public NombreCambiado(IdentificacionCliente entityId, Nombre nombre) {
        super("sofka.cliente.nombrecambiado");

        this.entityId =entityId;
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public IdentificacionCliente getEntityId() {
        return entityId;
    }
}
