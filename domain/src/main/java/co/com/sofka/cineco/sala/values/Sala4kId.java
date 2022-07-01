package co.com.sofka.cineco.sala.values;

import co.com.sofka.domain.generic.Identity;

public class Sala4kId extends Identity {

    public Sala4kId(){}
    private Sala4kId(String id){
        super(id);
    }

    public static Sala4kId of(String id){
        return new Sala4kId(id);
    }

}
