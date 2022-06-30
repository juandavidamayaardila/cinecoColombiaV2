package co.com.sofka.cineco.compra.comandos;

import co.com.sofka.cineco.compra.values.CompraId;
import co.com.sofka.cineco.compra.values.Fecha;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaCompra extends Command {


   private final CompraId entityId;
   private final Fecha fecha;

   public ActualizarFechaCompra(CompraId entityId, Fecha fecha){
       this.entityId = entityId;
       this.fecha = fecha;
   }

    public Fecha getFecha() {
        return fecha;
    }

    public CompraId getEntityId() {
        return entityId;
    }
}
