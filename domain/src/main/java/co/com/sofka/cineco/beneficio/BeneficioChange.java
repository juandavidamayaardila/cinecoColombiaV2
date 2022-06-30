package co.com.sofka.cineco.beneficio;

import co.com.sofka.cineco.beneficio.events.BeneficioCreado;
import co.com.sofka.cineco.beneficio.events.DescuentoActualizdo;
import co.com.sofka.domain.generic.EventChange;

public class BeneficioChange extends EventChange {
    public BeneficioChange(Beneficio beneficio) {

        apply((BeneficioCreado event) ->{
            beneficio.descripcion = event.getDescripcion();
            beneficio.descuento = event.getDescuento();
        });

        apply((DescuentoActualizdo event) ->{
            beneficio.descuento = event.getDescuento();
        });
    }
}
