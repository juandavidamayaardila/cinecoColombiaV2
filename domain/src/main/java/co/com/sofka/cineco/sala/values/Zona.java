package co.com.sofka.cineco.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Zona implements ValueObject<String > {

    private final String value;

    public Zona(String value){
        this.value = value;

        if(this.value.length() < 3){
            throw  new IllegalArgumentException("Por favor ingrese una Zona valida");
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
        Zona zona = (Zona) o;
        return Objects.equals(value, zona.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
