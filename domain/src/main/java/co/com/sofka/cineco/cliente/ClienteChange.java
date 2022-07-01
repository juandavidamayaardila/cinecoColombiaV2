package co.com.sofka.cineco.cliente;

import co.com.sofka.cineco.cliente.events.*;
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

        apply((TarjetaAgregada event) ->{
            cliente.tarjetaCineco = event.getTarjeta();
        });

        apply((PreferenciaAgregada event) ->{
            var numeroPreferencias = cliente.preferencias().size();
            if(numeroPreferencias == 4){
                throw  new IllegalArgumentException("Excede el numero de preferencias");
            }
            cliente.preferencias.add(new Preferencia(event.getPreferenciaId(), event.getDescripcionPreferencia()));

        });

        apply((DiasFrecuentaAgregada event) ->{
            var numeroFrecuenta = cliente.frecuentas().size();
            if(numeroFrecuenta == 4){
                throw  new IllegalArgumentException("Excede el numero de dias de frencuencia");
            }
            cliente.frecuentas.add(new DiasFrecuenta(event.getFrecuentaId(), event.getDescripcionFrecuenta()));

        });

    }
}
