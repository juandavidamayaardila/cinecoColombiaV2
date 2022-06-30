package co.com.sofka.cineco.tarjetacineco.events;

import co.com.sofka.cineco.beneficio.values.BeneficioId;
import co.com.sofka.cineco.beneficio.values.Descripcion;
import co.com.sofka.cineco.beneficio.values.Descuento;
import co.com.sofka.domain.generic.DomainEvent;

public class BeneficioAgregado extends DomainEvent {

    private final BeneficioId entityId;
    private final Descuento descuento;
    private final Descripcion descripcion;

    public BeneficioAgregado(BeneficioId entityId, Descripcion descripcion, Descuento descuento) {
        super("sofka.tarjeta.beneficioagregado");
        this.entityId = entityId;
        this.descripcion = descripcion;
        this.descuento = descuento;
    }

    public BeneficioId getEntityId() {
        return entityId;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
