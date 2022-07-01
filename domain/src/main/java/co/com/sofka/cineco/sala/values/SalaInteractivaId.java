package co.com.sofka.cineco.sala.values;

import co.com.sofka.domain.generic.Identity;

public class SalaInteractivaId extends Identity {

    public SalaInteractivaId(){}
    private SalaInteractivaId(String id){
        super(id);
    }

    public static SalaInteractivaId of(String id){
        return new SalaInteractivaId(id);
    }

}
