package co.com.sofka.cineco.cliente;

import co.com.sofka.cineco.cliente.values.DescripcionFrecuenta;
import co.com.sofka.cineco.cliente.values.DescripcionPreferencia;
import co.com.sofka.cineco.cliente.values.FrecuentaId;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;

public class DiasFrecuenta extends Entity<FrecuentaId> {

    private DescripcionFrecuenta descripcionFrecuenta;

    public DiasFrecuenta(FrecuentaId entityId, DescripcionFrecuenta descripcionFrecuenta) {
        super(entityId);
        this.descripcionFrecuenta = descripcionFrecuenta;
    }

    public DescripcionFrecuenta descripcionFrecuenta() {
        return descripcionFrecuenta;
    }

    public void actualizarDiasFrencuenta(DescripcionFrecuenta descripcionFrecuenta) {
        this.descripcionFrecuenta = descripcionFrecuenta;
    }
}
