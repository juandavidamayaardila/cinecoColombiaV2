package co.com.sofka.cineco.sala.events;

import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class AsientoCreado extends DomainEvent {

    private final Descripcion descripcion;

    public AsientoCreado(Descripcion descripcion) {
        super("sofka.asiento.asientocreado");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
