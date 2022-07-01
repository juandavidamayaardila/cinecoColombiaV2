package co.com.sofka.cineco.sala;

import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.cineco.sala.values.Sala4kId;
import co.com.sofka.domain.generic.Entity;

public class Sala4K extends Entity<Sala4kId> {

    protected Descripcion descripcion;

    public Sala4K(Sala4kId entityId, Descripcion descripcion) {
        super(entityId);
        this.descripcion = descripcion;
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;

    }
}
