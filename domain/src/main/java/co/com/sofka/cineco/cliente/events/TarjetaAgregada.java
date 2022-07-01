package co.com.sofka.cineco.cliente.events;

import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.tarjetacineco.TarjetaCineco;
import co.com.sofka.cineco.tarjetacineco.values.Beneficio;
import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class TarjetaAgregada extends DomainEvent {


    private final TarjetaCinecoId tarjeta;

    public TarjetaAgregada( TarjetaCinecoId tarjeta){

        super("sofka.cliente.tarjetacambiado");

        this.tarjeta = tarjeta;
    }

    public TarjetaCinecoId getTarjeta() {
        return tarjeta;
    }
}
