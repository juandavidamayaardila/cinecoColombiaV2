package co.com.sofka.cineco.sala.events;

import co.com.sofka.cineco.sala.values.SalaId;
import co.com.sofka.cineco.sala.values.TipoSala;
import co.com.sofka.domain.generic.DomainEvent;

public class ActualizarTipoSala extends DomainEvent {

    private final SalaId entityId;
    private final TipoSala tipoSala;
    public ActualizarTipoSala(SalaId entityId, TipoSala tipoSala) {
        super("sofka.sala.tiposalaactualizado");
        this.entityId = entityId;
        this.tipoSala = tipoSala;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public SalaId getEntityId() {
        return entityId;
    }
}
