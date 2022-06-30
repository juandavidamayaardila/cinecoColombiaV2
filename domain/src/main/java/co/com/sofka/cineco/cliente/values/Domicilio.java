package co.com.sofka.cineco.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Domicilio implements ValueObject<String > {

    private final String value;

    public Domicilio(String value){
        this.value = value;

        if(this.value.length() < 4){
            throw  new IllegalArgumentException("Por favor ingrese una Domicilio valida");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return Objects.equals(value, domicilio.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
