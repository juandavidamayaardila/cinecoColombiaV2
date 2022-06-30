package co.com.sofka.cineco.beneficio.values;

import co.com.sofka.cineco.compra.values.CompraId;
import co.com.sofka.domain.generic.Identity;

public class BeneficioId extends Identity {

    public BeneficioId(){}
    private BeneficioId(String id){
        super(id);
    }

    public static BeneficioId of(String id){
        return new BeneficioId(id);
    }
}
