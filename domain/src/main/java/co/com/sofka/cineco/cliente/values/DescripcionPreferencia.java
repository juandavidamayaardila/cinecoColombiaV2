package co.com.sofka.cineco.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionPreferencia implements ValueObject<String> {

    private final String value;

    public DescripcionPreferencia(String value) {
        this.value = value;

        if (this.value.length() < 3) {
            throw new IllegalArgumentException("Por favor ingrese un Nombre valido");
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
        DescripcionPreferencia that = (DescripcionPreferencia) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
