package co.com.sofka.cineco.cliente.events;

import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.tarjetacineco.TarjetaCineco;
import co.com.sofka.cineco.tarjetacineco.values.Beneficio;
import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class TarjetaAgregada extends DomainEvent {


    private final TarjetaCinecoId tarjetaCinecoId;

    private final Descripcion descripcion;
    private final Estado estado;
    private final List<Beneficio> listBeneficio;


    public TarjetaAgregada(TarjetaCinecoId entityId, Descripcion descripcion, Estado estado, List<Beneficio> listBeneficio) {

        super("sofka.cliente.tarjetaagregada");

        this.tarjetaCinecoId = entityId;
        this.descripcion = descripcion;
        this.estado = estado;
        this.listBeneficio = listBeneficio;
    }

    public TarjetaCinecoId getTarjetaCinecoId() {
        return tarjetaCinecoId;
    }

    public Estado getEstado() {
        return estado;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public List<Beneficio> getListBeneficio() {
        return listBeneficio;
    }
}
