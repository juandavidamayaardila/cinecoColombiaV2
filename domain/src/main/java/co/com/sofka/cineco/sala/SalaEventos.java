package co.com.sofka.cineco.sala;

import co.com.sofka.cineco.cliente.values.ComidaId;
import co.com.sofka.cineco.cliente.values.DescripcionComida;
import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.cineco.sala.values.SalaEventosId;
import co.com.sofka.domain.generic.Entity;

public class SalaEventos extends Entity<SalaEventosId> {

    protected Descripcion descripcion;

    public SalaEventos(SalaEventosId entityId, Descripcion descripcion) {
        super(entityId);

        this.descripcion = descripcion;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;

    }
}
