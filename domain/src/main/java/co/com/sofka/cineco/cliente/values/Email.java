package co.com.sofka.cineco.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String > {

    private final String value;

    public Email(String value){
        this.value = value;

        if(this.value.length() < 4){
            throw  new IllegalArgumentException("Por favor ingrese un email valido");
        }

        if(this.value.matches("/^[-\\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\\.){1,125}[A-Z]{2,63}$/i")){
            throw  new IllegalArgumentException("El email no es valido");
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
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
