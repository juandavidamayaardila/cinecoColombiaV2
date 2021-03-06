package co.com.sofka.cineco.tarjetacineco;


import co.com.sofka.cineco.tarjetacineco.events.ActualizarEstadoTarjeta;
import co.com.sofka.cineco.tarjetacineco.events.BeneficioAgregado;
import co.com.sofka.cineco.tarjetacineco.events.BeneficioCreadoaTarjeta;
import co.com.sofka.cineco.tarjetacineco.events.TarjetaCinecoCreada;
import co.com.sofka.cineco.tarjetacineco.values.Beneficio;
import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;
import java.util.Set;

public class TarjetaCineco extends AggregateEvent<TarjetaCinecoId> {

    protected Descripcion descripcion;
    protected Estado estado;

    protected Set<Beneficio> beneficios;

    public TarjetaCineco(TarjetaCinecoId entityId, Descripcion descripcion, Estado estado,
                         List<Beneficio> listBeneficio) {

        super(entityId);
        appendChange(new TarjetaCinecoCreada(entityId, descripcion, estado)).apply();
        appendChange(new BeneficioCreadoaTarjeta(listBeneficio));
    }

    private TarjetaCineco(TarjetaCinecoId entityId) {
        super(entityId);
        subscribe(new TarjetaCinecoChange(this));
    }

    public void actualizarEstadoTarjeta(TarjetaCinecoId entityId, Estado estado) {
        appendChange(new ActualizarEstadoTarjeta(entityId, estado)).apply();
    }

    public void agregarBeneficio(Beneficio beneficio) {
        appendChange(new BeneficioAgregado(beneficio)).apply();
    }

    /*
    public Optional<Beneficio> getBeneficioPorId(BeneficioId entityId){
        return beneficios
                .stream()
                .filter(beneficio -> beneficio.identity().equals(entityId))
                .findFirst();
    }*/

    public Estado estado() {
        return estado;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Set<Beneficio> getBeneficios() {
        return beneficios;
    }
}
