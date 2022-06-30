package co.com.sofka.cineco.compra.values;

import co.com.sofka.domain.generic.Identity;

public class CompraId extends Identity {

    public CompraId(){}
    private CompraId(String id){
        super(id);
    }

    public static CompraId of(String id){
        return new CompraId(id);
    }
}
