package co.com.sofka.cineco.cliente.values;

import co.com.sofka.cineco.beneficio.values.BeneficioId;
import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class IdentificacionCliente extends Identity {

    private final String value;
    private final Type type;


    private IdentificacionCliente(String value, Type type){

        this.value = value;
        this.type = type;
    }

    public static IdentificacionCliente of(Type type, String value) {
        return new IdentificacionCliente(value, type)    ;
    }

    @Override
    public String value(){
        return type+"-"+value;
    }

    public String getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public enum Type{
        PASAPORTE, CC, TI
    }

}
