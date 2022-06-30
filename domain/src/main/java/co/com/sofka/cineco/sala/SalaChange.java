package co.com.sofka.cineco.sala;

import co.com.sofka.cineco.sala.events.ActualizarTipoSala;
import co.com.sofka.cineco.sala.events.SalaCreada;
import co.com.sofka.domain.generic.EventChange;

public class SalaChange extends EventChange {
    public SalaChange(Sala sala) {

        apply((SalaCreada event) ->{
            sala.tipoSala = event.getTipoSala();
        });

        apply((ActualizarTipoSala event) ->{
            sala.tipoSala = event.getTipoSala();
        });
    }
}
