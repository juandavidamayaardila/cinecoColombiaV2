package co.com.sofka.cineco.cliente.values;

import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.domain.generic.Identity;

public class PreferenciaId extends Identity {

    public PreferenciaId(){}
    private PreferenciaId(String id){
        super(id);
    }

    public static PreferenciaId of(String id){
        return new PreferenciaId(id);
    }

}
