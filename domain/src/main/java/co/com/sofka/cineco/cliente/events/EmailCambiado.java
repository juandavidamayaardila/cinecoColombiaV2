package co.com.sofka.cineco.cliente.events;

import co.com.sofka.cineco.cliente.values.Email;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.domain.generic.DomainEvent;

public class EmailCambiado extends DomainEvent {

    private final IdentificacionCliente entityId;
    private final Email email;

    public EmailCambiado(IdentificacionCliente entityId, Email email){
        super("sofka.cliente.emailcambiado");
        this.entityId = entityId;
        this.email = email;
    }


    public Email getEmail() {
        return email;
    }

    public IdentificacionCliente getEntityId() {
        return entityId;
    }
}
