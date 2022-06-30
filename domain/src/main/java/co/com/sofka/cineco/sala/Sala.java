package co.com.sofka.cineco.sala;

import co.com.sofka.cineco.beneficio.Beneficio;
import co.com.sofka.cineco.compra.events.AsientoAgregado;
import co.com.sofka.cineco.sala.events.ActualizarTipoSala;
import co.com.sofka.cineco.sala.events.AsientoAgregadoSala;
import co.com.sofka.cineco.sala.events.SalaCreada;
import co.com.sofka.cineco.sala.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;
import java.util.Set;

public class Sala extends AggregateEvent<SalaId> {
    protected TipoSala tipoSala;
    protected Zona zona;
    protected Set<Asiento> asientos;

    public Sala(SalaId entityId, TipoSala tipoSala, List<Asiento> listAsiento) {

        super(entityId);
        appendChange(new SalaCreada(tipoSala)).apply();
        appendChange(new AsientoAgregadoSala(listAsiento));

        subscribe(new SalaChange(this));
    }
    public void actualizarTipoSala( TipoSala tipoSala){
        appendChange(new ActualizarTipoSala(entityId, tipoSala )).apply();
    }

    public void agregarAsientos(AsientoId entityId, Descripcion descripcion){
        appendChange(new AsientoAgregado(entityId, descripcion));
    }

    public Set<Asiento> getAsientos() {
        return asientos;
    }
}
