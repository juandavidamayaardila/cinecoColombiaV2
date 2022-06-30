package co.com.sofka.cineco.tarjetacineco.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estado implements ValueObject {

    private final Boolean value;

    public Estado(Boolean value){
        this.value = value;

        /**
         * Valida si es un boolean valido
         */
        /*
        if(Boolean.){
            throw  new IllegalArgumentException("Por favor ingrese un Descripcion valido");
        }
         */
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(value, estado.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
