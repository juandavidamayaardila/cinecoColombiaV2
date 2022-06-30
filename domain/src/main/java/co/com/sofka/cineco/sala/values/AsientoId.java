package co.com.sofka.cineco.sala.values;

import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class AsientoId extends Identity {

    public AsientoId(){}
    private AsientoId(String id){
        super(id);
    }

    public static AsientoId of(String id){
        return new AsientoId(id);
    }

}
