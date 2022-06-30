package co.com.sofka.cineco.beneficio.events;

import co.com.sofka.cineco.beneficio.Beneficio;
import co.com.sofka.cineco.beneficio.values.BeneficioId;
import co.com.sofka.cineco.beneficio.values.Descuento;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class DescuentoActualizdo extends DomainEvent {

    private  final BeneficioId entityId;
    private final Descuento descuento;

    public DescuentoActualizdo(BeneficioId entityId, Descuento descuento) {
        super("sofka.beneficio.beneficioactualizado");
        this.entityId = entityId;
        this.descuento = descuento;

    }

    public Descuento getDescuento() {
        return descuento;
    }

    public BeneficioId getEntityId() {
        return entityId;
    }


}
