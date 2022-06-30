package co.com.sofka.cineco.beneficio.events;

import co.com.sofka.cineco.beneficio.values.Descripcion;
import co.com.sofka.cineco.beneficio.values.Descuento;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class BeneficioCreado extends DomainEvent {
    private final Descuento descuento;
    private final Descripcion descripcion;

    public BeneficioCreado(Descripcion descripcion, Descuento descuento) {
        super("sofka.beenficio.beneficiocreado");
        this.descripcion = descripcion;
        this.descuento = descuento;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
