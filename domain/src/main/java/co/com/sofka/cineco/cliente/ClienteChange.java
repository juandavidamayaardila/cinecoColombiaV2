package co.com.sofka.cineco.cliente;

import co.com.sofka.cineco.cliente.events.ClienteCreado;
import co.com.sofka.cineco.cliente.events.NombreCambiado;
import co.com.sofka.cineco.cliente.events.TarjetaAgregadaCliente;
import co.com.sofka.domain.generic.EventChange;

public class ClienteChange extends EventChange {
    public ClienteChange(Cliente cliente) {

        apply((ClienteCreado event) ->{
            cliente.nombre = event.getNombre();
            cliente.email = event.getEmail();
        });

        apply((NombreCambiado event) ->{
            cliente.nombre = event.getNombre();
        });

        apply((TarjetaAgregadaCliente event) ->{
            cliente.tarjetaCinecoId = event.getEntityId();
        });
    }
}
