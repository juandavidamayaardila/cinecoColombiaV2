package co.com.sofka.cineco.sala.comandos;

import co.com.sofka.cineco.sala.values.SalaId;
import co.com.sofka.cineco.sala.values.TipoSala;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipoSala extends Command {

    private  final SalaId entityId;
    private final TipoSala tipoSala;

    public ActualizarTipoSala(SalaId entityId, TipoSala tipoSala){
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
