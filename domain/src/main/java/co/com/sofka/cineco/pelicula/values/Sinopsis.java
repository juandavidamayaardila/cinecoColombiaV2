package co.com.sofka.cineco.pelicula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Sinopsis implements ValueObject<String> {

    private final String value;

    public Sinopsis(String value){
        this.value = value;

        if(this.value.length() < 10){
            throw  new IllegalArgumentException("Por favor ingrese un Sinopsis valido");
        }

        if(this.value.length() > 100){
            throw  new IllegalArgumentException("Por favor ingrese un Sinopsis valido");
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
        Sinopsis sinopsis = (Sinopsis) o;
        return Objects.equals(value, sinopsis.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
