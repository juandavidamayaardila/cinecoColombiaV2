package co.com.sofka.cineco.cliente.events;

import co.com.sofka.cineco.cliente.values.DescripcionFrecuenta;
import co.com.sofka.cineco.cliente.values.FrecuentaId;
import co.com.sofka.domain.generic.DomainEvent;

public class DiasFrecuentaAgregada extends DomainEvent {

    private final FrecuentaId frecuentaId;
    private final DescripcionFrecuenta descripcionFrecuenta;

    public DiasFrecuentaAgregada(FrecuentaId entityId, DescripcionFrecuenta descripcionFrecuenta) {
        super("sofka.cliente.frecuentaagregada");

        this.frecuentaId = entityId;
        this.descripcionFrecuenta = descripcionFrecuenta;
    }

    public DescripcionFrecuenta getDescripcionFrecuenta() {
        return descripcionFrecuenta;
    }

    public FrecuentaId getFrecuentaId() {
        return frecuentaId;
    }
}
