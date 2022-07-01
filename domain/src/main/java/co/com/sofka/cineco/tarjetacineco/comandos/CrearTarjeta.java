package co.com.sofka.cineco.tarjetacineco.comandos;


import co.com.sofka.cineco.tarjetacineco.values.Beneficio;
import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.Command;

import java.util.List;

public class CrearTarjeta extends Command {

    //  private final TarjetaCinecoId entityId;
    private final Descripcion descripcion;
    private final Estado estado;

    private final List<Beneficio> beneficioList;

    public CrearTarjeta(Descripcion descripcion, Estado estado, List<Beneficio> beneficioList) {
        // this.entityId = entityId;
        this.descripcion = descripcion;
        this.estado = estado;
        this.beneficioList = beneficioList;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public List<Beneficio> getBeneficioList() {
        return beneficioList;
    }

    /*
    public TarjetaCinecoId getEntityId() {
        return entityId;
    }*/
}
