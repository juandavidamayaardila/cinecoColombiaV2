package co.com.sofka.cineco.tarjetacineco.values;

import co.com.sofka.domain.generic.Identity;

public class TarjetaCinecoId extends Identity {

    public TarjetaCinecoId(){}
    private TarjetaCinecoId(String id){
        super(id);
    }

    public static TarjetaCinecoId of(String id){
        return new TarjetaCinecoId(id);
    }
}
