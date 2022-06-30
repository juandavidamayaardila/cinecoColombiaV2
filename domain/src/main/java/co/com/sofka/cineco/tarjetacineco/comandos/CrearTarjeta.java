package co.com.sofka.cineco.tarjetacineco.comandos;

import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.Command;

public class CrearTarjeta extends Command {
    
  //  private final TarjetaCinecoId entityId;
    private final Descripcion descripcion;
    private final Estado estado;
    
    public CrearTarjeta( Descripcion descripcion, Estado estado){
       // this.entityId = entityId;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    /*
    public TarjetaCinecoId getEntityId() {
        return entityId;
    }*/
}
