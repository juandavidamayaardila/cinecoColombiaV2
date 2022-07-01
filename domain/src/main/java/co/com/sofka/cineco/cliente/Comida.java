package co.com.sofka.cineco.cliente;

import co.com.sofka.cineco.cliente.values.ComidaId;
import co.com.sofka.cineco.cliente.values.DescripcionComida;
import co.com.sofka.domain.generic.Entity;

public class Comida extends Entity<ComidaId> {

    protected DescripcionComida descripcionComida;

    public Comida(ComidaId entityId, DescripcionComida descripcionComida) {
        super(entityId);

        this.descripcionComida = descripcionComida;
    }

    public DescripcionComida descripcionComida() {
        return descripcionComida;
    }

    public void actualizarDescripcionComida(DescripcionComida descripcionComida) {
        this.descripcionComida = descripcionComida;

    }
}
