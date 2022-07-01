package co.com.sofka.cineco.cliente.events;

import co.com.sofka.cineco.cliente.values.DescripcionPreferencia;
import co.com.sofka.cineco.cliente.values.PreferenciaId;
import co.com.sofka.domain.generic.DomainEvent;

public class PreferenciaAgregada extends DomainEvent {

    private final PreferenciaId preferenciaId;
    private final DescripcionPreferencia descripcionPreferencia;

    public PreferenciaAgregada(PreferenciaId entityId, DescripcionPreferencia descripcionPreferencia) {
        super("sofka.cliente.prefrenciaagregada");

        this.preferenciaId = entityId;
        this.descripcionPreferencia = descripcionPreferencia;
    }

    public DescripcionPreferencia getDescripcionPreferencia() {
        return descripcionPreferencia;
    }

    public PreferenciaId getPreferenciaId() {
        return preferenciaId;
    }
}
