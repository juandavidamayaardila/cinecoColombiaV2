package co.com.sofka.cineco.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FechaCumplenos implements ValueObject<String > {

    private final String value;

    public FechaCumplenos(String value){
        this.value = value;

        if(this.value.length() < 10){
            throw  new IllegalArgumentException("Por favor ingrese un FechaCumplenos valido");
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
        FechaCumplenos that = (FechaCumplenos) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
