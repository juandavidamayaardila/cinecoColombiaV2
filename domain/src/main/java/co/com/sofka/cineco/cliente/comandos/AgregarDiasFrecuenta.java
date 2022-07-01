package co.com.sofka.cineco.cliente.comandos;

import co.com.sofka.cineco.cliente.values.DescripcionFrecuenta;
import co.com.sofka.cineco.cliente.values.DescripcionPreferencia;
import co.com.sofka.cineco.cliente.values.FrecuentaId;
import co.com.sofka.cineco.cliente.values.PreferenciaId;
import co.com.sofka.domain.generic.Command;

public class AgregarDiasFrecuenta extends Command {

    private final FrecuentaId preferenciaId;
    private final DescripcionFrecuenta descripcionPreferencia;

    public AgregarDiasFrecuenta(FrecuentaId entityId, DescripcionFrecuenta descripcionPreferencia) {
        this.preferenciaId = entityId;
        this.descripcionPreferencia = descripcionPreferencia;
    }

    public FrecuentaId getPreferenciaId() {
        return preferenciaId;
    }

    public DescripcionFrecuenta getDescripcionPreferencia() {
        return descripcionPreferencia;
    }
}
