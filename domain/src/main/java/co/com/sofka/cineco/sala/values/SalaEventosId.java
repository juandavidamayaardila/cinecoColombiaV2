package co.com.sofka.cineco.sala.values;

import co.com.sofka.domain.generic.Identity;

public class SalaEventosId extends Identity {

    public SalaEventosId(){}
    private SalaEventosId(String id){
        super(id);
    }

    public static SalaEventosId of(String id){
        return new SalaEventosId(id);
    }

}
