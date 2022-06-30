package co.com.sofka.cineco.cliente.comandos;

import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;

public class AgregarTarjeta {

    private final TarjetaCinecoId entityId;
    private final Descripcion descripcion;
    private final Estado estado;

    public AgregarTarjeta(TarjetaCinecoId entityId, Descripcion descripcion, Estado estado){
        this.entityId = entityId;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public TarjetaCinecoId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }
}
