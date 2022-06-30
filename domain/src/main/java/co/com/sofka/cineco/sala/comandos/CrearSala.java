package co.com.sofka.cineco.sala.comandos;

import co.com.sofka.cineco.sala.Asiento;
import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.cineco.sala.values.SalaId;
import co.com.sofka.cineco.sala.values.TipoSala;
import co.com.sofka.domain.generic.Command;

import java.util.ArrayList;
import java.util.List;

public class CrearSala extends Command {


    private final TipoSala tipoSala;
    private final List<Asiento> asiento;


    public CrearSala( TipoSala tipoSala, List<Asiento> asientos){

        this.tipoSala = tipoSala;
        this.asiento = asientos;
    }


    public List<Asiento> getAsiento() {
        return asiento;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }
}
