package co.com.sofka.cineco.pelicula.comandos;

import co.com.sofka.cineco.pelicula.values.DescripcionIdioma;
import co.com.sofka.cineco.pelicula.values.IdiomaId;
import co.com.sofka.domain.generic.Command;

public class AgregarIdiomas extends Command {

    private  final IdiomaId idiomaId;
    private final DescripcionIdioma descripcionIdioma;

    public AgregarIdiomas(IdiomaId entityId, DescripcionIdioma descripcionIdioma){
        this.idiomaId = entityId;
        this.descripcionIdioma = descripcionIdioma;
    }

    public IdiomaId getIdiomaId() {
        return idiomaId;
    }

    public DescripcionIdioma getDescripcionIdioma() {
        return descripcionIdioma;
    }
}
