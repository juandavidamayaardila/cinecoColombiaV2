package co.com.sofka.cineco.compra;

import co.com.sofka.cineco.compra.events.AsientoAgregado;
import co.com.sofka.cineco.compra.events.CompraRealizada;
import co.com.sofka.cineco.compra.events.FechaActualizada;
import co.com.sofka.cineco.compra.events.PeliculaAgregada;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.cineco.sala.Asiento;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;
import java.util.Optional;

public class CompraChange extends EventChange {

    /**
     * Afectando los estados de la entidad, realizando los cambios
     * se toman los paremtros necesarios para crearla los demas se
     * inicializan en cero.
     *
     * preguntar a Raul como queda pelicula ya que la compra se crea con clienteid y fecha
     * y despues hay un evento para agregar asientos y pelicula.
     *
     * @param compra
     */
    public CompraChange(Compra compra)  {

        apply((CompraRealizada event) ->{
            compra.fecha = event.getFecha();
            compra.clienteid = event.getClienteid();
            compra.asientos = new HashSet<>();
            compra.peliculaId = new PeliculaId();

        });

        apply((AsientoAgregado event) ->{
            var numeroAsientos = compra.asientos().size();
            if(numeroAsientos == 6){
                throw new IllegalArgumentException("No puede comprar mas asientos para esta pelicula");
            }
            compra.asientos.add(new Asiento(
             event.getEntityId(),
                    event.getDescripcion()
            ));
        });

        apply((FechaActualizada event) ->{
            compra.fecha = event.getFecha();
        });

        apply((PeliculaAgregada event) ->{
            compra.peliculaId = event.getEntityId();
        });
    }
}
