package co.com.sofka.cineco.tarjetacineco.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject {


    private final String value;

    public Descripcion(String value){
        this.value = value;

        if(this.value.length() < 3){
            throw  new IllegalArgumentException("Por favor ingrese una Descripcion valida");
        }
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descripcion that = (Descripcion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
