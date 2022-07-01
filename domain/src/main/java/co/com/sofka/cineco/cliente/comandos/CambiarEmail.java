package co.com.sofka.cineco.cliente.comandos;

import co.com.sofka.cineco.cliente.values.Email;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.domain.generic.Command;

public class CambiarEmail extends Command {

    private final IdentificacionCliente entityId;
    private final Email email;

    public CambiarEmail(IdentificacionCliente entityId, Email email) {
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
