package co.com.sofka.cineco.sala;

import co.com.sofka.cineco.sala.events.AsientoCreado;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.EventChange;

public class AsientoChange extends EventChange {
    public AsientoChange(Asiento asiento) {
        apply((AsientoCreado event) ->{
            asiento.descripcion = event.getDescripcion();
        });
    }
}
