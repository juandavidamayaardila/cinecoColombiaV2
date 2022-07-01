package co.com.sofka.cineco.pelicula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionIdioma implements ValueObject<String > {
    private final String value;

    public DescripcionIdioma(String value){
        this.value = value;

        if(this.value.length() < 4){
            throw  new IllegalArgumentException("Por favor ingrese un Nombre valido");
        }
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescripcionIdioma that = (DescripcionIdioma) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
