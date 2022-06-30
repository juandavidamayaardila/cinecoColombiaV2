package co.com.sofka.cineco.cliente.events;

import co.com.sofka.cineco.cliente.values.Email;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class ClienteCreado extends DomainEvent {

    protected Nombre nombre;
    protected Email email;

    public ClienteCreado(Nombre nombre, Email email) {

        super("sofka.cliente.clientecreado");
        this.nombre = nombre;
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
