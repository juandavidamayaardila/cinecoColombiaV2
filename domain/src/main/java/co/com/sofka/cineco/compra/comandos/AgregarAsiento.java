package co.com.sofka.cineco.compra.comandos;

import co.com.sofka.cineco.sala.values.AsientoId;
import co.com.sofka.domain.generic.Command;

public class AgregarAsiento extends Command {

    private final AsientoId entityId;

    public AgregarAsiento(AsientoId entityId){
        this.entityId = entityId;
    }

    public AsientoId getEntityId() {
        return entityId;
    }
}
