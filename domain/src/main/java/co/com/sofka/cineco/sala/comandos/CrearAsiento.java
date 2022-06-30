package co.com.sofka.cineco.sala.comandos;

import co.com.sofka.cineco.sala.values.AsientoId;
import co.com.sofka.cineco.sala.values.Descripcion;

public class CrearAsiento {

    private final AsientoId entityId;
    private final Descripcion descripcion;

    public CrearAsiento(AsientoId entityId, Descripcion descripcion){
        this.entityId = entityId;
        this.descripcion = descripcion;

    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public AsientoId getEntityId() {
        return entityId;
    }
}
