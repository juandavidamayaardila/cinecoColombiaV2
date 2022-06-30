package co.com.sofka.cineco.sala;

import co.com.sofka.cineco.sala.events.AsientoCreado;
import co.com.sofka.cineco.sala.values.AsientoId;
import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.domain.generic.AggregateEvent;

public class Asiento extends AggregateEvent<AsientoId> {

    protected Descripcion descripcion;

    public Asiento(AsientoId entityId, Descripcion descripcion) {
        super(entityId);
        appendChange(new AsientoCreado(descripcion)).apply();
    }

    private Asiento(AsientoId entityId){
        super(entityId);
        subscribe(new AsientoChange(this));
    }
}
