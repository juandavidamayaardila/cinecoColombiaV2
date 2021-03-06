package co.com.sofka.cineco.tarjetacineco;

import co.com.sofka.cineco.tarjetacineco.events.ActualizarEstadoTarjeta;
import co.com.sofka.cineco.tarjetacineco.events.BeneficioAgregado;
import co.com.sofka.cineco.tarjetacineco.events.TarjetaCinecoCreada;
import co.com.sofka.domain.generic.EventChange;

public class TarjetaCinecoChange extends EventChange {
    public TarjetaCinecoChange(TarjetaCineco tarjetaCineco) {

        apply((TarjetaCinecoCreada event) -> {
            tarjetaCineco.descripcion = event.getDescripcion();
            tarjetaCineco.estado = event.getEstado();

        });

        apply((ActualizarEstadoTarjeta event) -> {
            tarjetaCineco.estado = event.getEstado();
        });
    }
}
