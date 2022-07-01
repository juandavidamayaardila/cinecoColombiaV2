package co.com.sofka.cineco.sala.events;

import co.com.sofka.cineco.sala.values.SalaId;
import co.com.sofka.cineco.sala.values.TipoSala;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionActualizada extends DomainEvent {
    public DescripcionActualizada(SalaId entityId, TipoSala tipoSala) {
        super("sofka.sala.descripcionactualizada");
    }
}
