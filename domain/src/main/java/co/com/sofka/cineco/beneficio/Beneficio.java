package co.com.sofka.cineco.beneficio;

import co.com.sofka.cineco.beneficio.events.BeneficioCreado;
import co.com.sofka.cineco.beneficio.events.DescuentoActualizdo;
import co.com.sofka.cineco.beneficio.values.BeneficioId;
import co.com.sofka.cineco.beneficio.values.Descripcion;
import co.com.sofka.cineco.beneficio.values.Descuento;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Set;

public class Beneficio extends AggregateEvent<BeneficioId> {

    protected Descripcion descripcion;

    protected Descuento descuento;

    public Beneficio(BeneficioId entityId, Descripcion descripcion, Descuento descuento) {

        super(entityId);
        appendChange(new BeneficioCreado(descripcion,descuento)).apply();
    }

    private Beneficio(BeneficioId entityId){
        super(entityId);
        subscribe(new BeneficioChange(this));
    }

    public void actualizarDescuento(BeneficioId beneficioId, Descuento descuento){
        appendChange(new DescuentoActualizdo(beneficioId, descuento));
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Descuento descuento() {
        return descuento;
    }


}
