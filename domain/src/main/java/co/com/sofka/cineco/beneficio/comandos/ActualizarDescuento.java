package co.com.sofka.cineco.beneficio.comandos;

import co.com.sofka.cineco.beneficio.values.BeneficioId;
import co.com.sofka.cineco.beneficio.values.Descuento;
import co.com.sofka.domain.generic.Command;

public class ActualizarDescuento extends Command {

    private final BeneficioId entityId;
    private final Descuento descuento;

    public ActualizarDescuento(BeneficioId entityId, Descuento descuento){
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
