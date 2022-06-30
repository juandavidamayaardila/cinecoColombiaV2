package co.com.sofka.cineco.compra.comandos;

import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.compra.values.CompraId;
import co.com.sofka.cineco.compra.values.Fecha;

public class CrearCompra {

    protected final CompraId entityId;
    protected final IdentificacionCliente clienteId;
    protected final Fecha fecha;

    public CrearCompra(CompraId entityId, IdentificacionCliente clienteid, Fecha fecha){
        this.entityId = entityId;
        this.clienteId = clienteid;
        this.fecha = fecha;
    }

    public CompraId getEntityId() {
        return entityId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
