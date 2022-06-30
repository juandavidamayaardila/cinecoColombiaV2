package co.com.sofka.cineco.pelicula.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sun.jdi.Value;

import java.util.Objects;

public class Genero implements ValueObject<String > {

    private final String value;

    public Genero(String value){
        this.value = value;

        if(this.value.length() < 4){
            throw  new IllegalArgumentException("Por favor ingrese un Genero valido");
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
        Genero genero = (Genero) o;
        return Objects.equals(value, genero.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
