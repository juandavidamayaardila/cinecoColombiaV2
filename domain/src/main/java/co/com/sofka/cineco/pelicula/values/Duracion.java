package co.com.sofka.cineco.pelicula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Duracion implements ValueObject<Integer> {

    private final Integer value;

    public Duracion(Integer value){
        this.value = value;

        /**
         * Valida si es un numero valido
         */
       /* if(this.value.p){
            throw  new IllegalArgumentException("Por favor ingrese una duracion valida");
        }
        */

    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duracion duracion = (Duracion) o;
        return Objects.equals(value, duracion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
