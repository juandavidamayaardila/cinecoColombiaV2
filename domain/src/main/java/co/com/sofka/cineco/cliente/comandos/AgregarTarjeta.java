package co.com.sofka.cineco.cliente.comandos;

import co.com.sofka.cineco.cliente.events.TarjetaAgregada;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.tarjetacineco.TarjetaCineco;
import co.com.sofka.cineco.tarjetacineco.values.Beneficio;
import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.Command;

import java.util.List;

public class AgregarTarjeta extends Command {

    private final IdentificacionCliente entityId;

    private final TarjetaCinecoId  tarjetaCinecoId;

    public AgregarTarjeta(IdentificacionCliente entityId, TarjetaCinecoId tarjetaCinecoId){
        this.entityId = entityId;
        this.tarjetaCinecoId = tarjetaCinecoId;

    }

    public IdentificacionCliente getEntityId() {
        return entityId;
    }

    public TarjetaCinecoId getTarjetaCinecoId() {
        return tarjetaCinecoId;
    }
}
