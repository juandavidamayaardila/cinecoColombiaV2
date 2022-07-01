package co.com.sofka.cineco.tarjetacineco.events;


import co.com.sofka.cineco.tarjetacineco.values.Beneficio;
import co.com.sofka.domain.generic.DomainEvent;

public class BeneficioAgregado extends DomainEvent {

    private final Beneficio beneficio;


    public BeneficioAgregado(Beneficio beneficio) {
        super("sofka.tarjeta.beneficioagregado");
        this.beneficio = beneficio;
    }

    public Beneficio getBeneficio() {
        return beneficio;
    }
}
