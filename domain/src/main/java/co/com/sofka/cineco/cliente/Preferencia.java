package co.com.sofka.cineco.cliente;

import co.com.sofka.cineco.cliente.values.DescripcionPreferencia;
import co.com.sofka.cineco.cliente.values.PreferenciaId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Preferencia extends Entity<PreferenciaId> {

    private  DescripcionPreferencia descripcionPreferencia;

    public Preferencia(PreferenciaId entityId, DescripcionPreferencia descripcionPreferencia) {
        super(entityId);
        this.descripcionPreferencia = descripcionPreferencia;
    }

    public DescripcionPreferencia descripcionPreferencia() {
        return descripcionPreferencia;
    }

    public void actualizarDescripcion(DescripcionPreferencia descripcionPreferencia){
        this.descripcionPreferencia = Objects.requireNonNull(descripcionPreferencia);
    }
}
