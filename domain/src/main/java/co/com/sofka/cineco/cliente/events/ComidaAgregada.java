package co.com.sofka.cineco.cliente.events;

import co.com.sofka.cineco.cliente.values.ComidaId;
import co.com.sofka.cineco.cliente.values.DescripcionComida;
import co.com.sofka.domain.generic.DomainEvent;

public class ComidaAgregada extends DomainEvent {

    private final ComidaId comidaId;
    private final DescripcionComida descripcionComida;
    public ComidaAgregada(ComidaId entityId, DescripcionComida descripcionComida) {
        super("sofka.cliente.comidaagregada");
        this.comidaId = entityId;
        this.descripcionComida = descripcionComida;
    }

    public ComidaId getComidaId() {
        return comidaId;
    }

    public DescripcionComida getDescripcionComida() {
        return descripcionComida;
    }
}
