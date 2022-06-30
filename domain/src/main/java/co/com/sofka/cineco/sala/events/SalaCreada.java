package co.com.sofka.cineco.sala.events;

import co.com.sofka.cineco.sala.values.TipoSala;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class SalaCreada extends DomainEvent {

    protected TipoSala tipoSala;

    public SalaCreada(TipoSala tipoSala) {
        super("sofka.sala.salacreada");
        this.tipoSala = tipoSala;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }
}
