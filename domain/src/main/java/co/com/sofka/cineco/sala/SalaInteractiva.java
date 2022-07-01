package co.com.sofka.cineco.sala;

import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.cineco.sala.values.SalaEventosId;
import co.com.sofka.cineco.sala.values.SalaInteractivaId;
import co.com.sofka.domain.generic.Entity;

public class SalaInteractiva extends Entity<SalaInteractivaId> {

    protected Descripcion descripcion;

    public SalaInteractiva(SalaInteractivaId entityId,  Descripcion descripcion) {
        super(entityId);
        this.descripcion = descripcion;
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;

    }
}
