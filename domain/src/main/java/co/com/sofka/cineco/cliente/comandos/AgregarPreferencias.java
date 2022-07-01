package co.com.sofka.cineco.cliente.comandos;

import co.com.sofka.cineco.cliente.values.DescripcionFrecuenta;
import co.com.sofka.cineco.cliente.values.DescripcionPreferencia;
import co.com.sofka.cineco.cliente.values.PreferenciaId;
import co.com.sofka.domain.generic.Command;

public class AgregarPreferencias extends Command {

    private final PreferenciaId preferenciaId;
    private final DescripcionPreferencia descripcionPreferencia;

    public AgregarPreferencias(PreferenciaId entityId, DescripcionPreferencia descripcionPreferencia){
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
