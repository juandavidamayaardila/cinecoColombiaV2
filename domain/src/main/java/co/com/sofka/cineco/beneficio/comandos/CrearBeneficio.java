package co.com.sofka.cineco.beneficio.comandos;

import co.com.sofka.cineco.beneficio.Beneficio;
import co.com.sofka.cineco.beneficio.values.BeneficioId;
import co.com.sofka.cineco.beneficio.values.Descripcion;
import co.com.sofka.cineco.beneficio.values.Descuento;

public class CrearBeneficio {

    private final BeneficioId entityId;
    private final Descripcion descripcion;
    private final Descuento descuento;

    public CrearBeneficio(BeneficioId entityId, Descripcion descripcion, Descuento descuento){
        this.entityId = entityId;
        this.descripcion = descripcion;
        this.descuento = descuento;
    }

    public BeneficioId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
