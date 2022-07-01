package co.com.sofka.cineco.compra.comandos;

import co.com.sofka.cineco.sala.values.Asiento;
import co.com.sofka.cineco.sala.values.AsientoId;
import co.com.sofka.domain.generic.Command;

public class AgregarAsiento extends Command {

    private final Asiento asiento;

    public AgregarAsiento(Asiento asiento){
        this.asiento = asiento;
    }

    public Asiento getEntityId() {
        return asiento;
    }
}
