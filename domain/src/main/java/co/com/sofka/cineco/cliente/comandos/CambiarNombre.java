package co.com.sofka.cineco.cliente.comandos;

import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.cliente.values.Nombre;

public class CambiarNombre {

    private final IdentificacionCliente entityId;
    private final Nombre nombre;

    public CambiarNombre(IdentificacionCliente entityId, Nombre nombre){
        this.entityId = entityId;
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public IdentificacionCliente getEntityId() {
        return entityId;
    }
}
