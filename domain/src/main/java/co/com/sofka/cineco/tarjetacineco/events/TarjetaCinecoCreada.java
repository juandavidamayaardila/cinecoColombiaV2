package co.com.sofka.cineco.tarjetacineco.events;

import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.DomainEvent;

public class TarjetaCinecoCreada extends DomainEvent {

    private  final TarjetaCinecoId entityId;
    private final Descripcion descripcion;
    private final Estado estado;

    public TarjetaCinecoCreada(TarjetaCinecoId entityId, Descripcion descripcion, Estado estado) {
        super("sofka.tarjeta.tarjetacreada");
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
