package co.com.sofka.cineco.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Asiento implements ValueObject {

    private final String value;


    public Asiento(String value){
        this.value = value;
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asiento asiento = (Asiento) o;
        return Objects.equals(value, asiento.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
