package co.com.sofka.cineco.tarjetacineco.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Beneficio implements ValueObject {

    private final String descripcion;
    private final String descuento;

    public Beneficio(String descripcion,String descuento){

        this.descripcion = descripcion;
        this.descuento = descuento;

    }

    @Override
    public Object value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficio beneficio = (Beneficio) o;
        return Objects.equals(descripcion, beneficio.descripcion) && Objects.equals(descuento, beneficio.descuento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, descuento);
    }

    public String descripcion() {
        return descripcion;
    }

    public String descuento() {
        return descuento;
    }
}
