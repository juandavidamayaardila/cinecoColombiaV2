package co.com.sofka.cineco.cliente.values;


import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class IdentificacionCliente extends Identity {

    private IdentificacionCliente(String value, Type type) {

        super(type + "-" + value);
    }

    private IdentificacionCliente(String id) {

        super(id);
    }

    public static IdentificacionCliente of(Type type, String value) {
        return new IdentificacionCliente(value, type);
    }

    public static IdentificacionCliente of(String id) {
        return new IdentificacionCliente(id);
    }

    public enum Type {
        PASAPORTE, CC, TI
    }

}
