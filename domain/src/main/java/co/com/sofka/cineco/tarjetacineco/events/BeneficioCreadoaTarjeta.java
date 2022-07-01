package co.com.sofka.cineco.tarjetacineco.events;


import co.com.sofka.cineco.tarjetacineco.values.Beneficio;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class BeneficioCreadoaTarjeta extends DomainEvent {

    private final List<Beneficio> listBeneficio;

    public BeneficioCreadoaTarjeta(List<Beneficio> listBeneficio) {
        super("sofka.tarjeta.beneficioagregadotarjeta");
        this.listBeneficio = listBeneficio;
    }

    public List<Beneficio> getListBeneficio() {
        return listBeneficio;
    }
}
