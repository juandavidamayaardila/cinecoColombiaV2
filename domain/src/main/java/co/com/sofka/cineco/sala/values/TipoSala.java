package co.com.sofka.cineco.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoSala implements ValueObject<String> {

    private final String value;

    public TipoSala(String value){
        this.value = value;

        if(this.value.length() < 4){
            throw  new IllegalArgumentException("Por favor ingrese un TipoSala valido");
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
        TipoSala tipoSala = (TipoSala) o;
        return Objects.equals(value, tipoSala.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
