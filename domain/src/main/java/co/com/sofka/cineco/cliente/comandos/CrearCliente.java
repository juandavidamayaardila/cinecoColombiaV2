package co.com.sofka.cineco.cliente.comandos;

import co.com.sofka.cineco.cliente.values.Email;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class CrearCliente extends Command {

    private final IdentificacionCliente entityId;
    private final Nombre nombre;
    private final Email email;

    public CrearCliente(IdentificacionCliente entityId, Nombre nombre, Email email) {
        this.entityId = entityId;
        this.nombre = nombre;
        this.email = email;
    }

    public IdentificacionCliente getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }
}
