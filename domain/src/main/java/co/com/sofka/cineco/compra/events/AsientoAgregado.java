package co.com.sofka.cineco.compra.events;

import co.com.sofka.cineco.sala.values.Asiento;
import co.com.sofka.domain.generic.DomainEvent;

public class AsientoAgregado extends DomainEvent {

    private final Asiento asiento;
    public AsientoAgregado(Asiento asiento) {

        super("sofka.cliente.asientoagregado");
        this.asiento = asiento;
    }

    public Asiento asiento() {
        return asiento;
    }
}
