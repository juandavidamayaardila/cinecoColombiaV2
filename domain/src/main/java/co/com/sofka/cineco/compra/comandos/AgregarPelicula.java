package co.com.sofka.cineco.compra.comandos;

import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.compra.Compra;
import co.com.sofka.cineco.compra.values.CompraId;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.cineco.pelicula.values.Sinopsis;
import co.com.sofka.domain.generic.Command;

public class AgregarPelicula extends Command {

    private final CompraId compraId;
    private final PeliculaId entityId;
    private final Nombre nombre;
    private final Sinopsis sinopsis;

    public AgregarPelicula(CompraId compraId, PeliculaId entityId, Nombre nombre, Sinopsis sinopsis){
        this.compraId = compraId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.sinopsis = sinopsis;
    }

    public CompraId getCompraId() {
        return compraId;
    }

    public PeliculaId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Sinopsis getSinopsis() {
        return sinopsis;
    }
}
