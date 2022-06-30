package co.com.sofka.cineco.tarjetacineco;

import co.com.sofka.cineco.beneficio.Beneficio;
import co.com.sofka.cineco.beneficio.values.BeneficioId;
import co.com.sofka.cineco.beneficio.values.Descuento;
import co.com.sofka.cineco.sala.Asiento;
import co.com.sofka.cineco.sala.values.AsientoId;
import co.com.sofka.cineco.tarjetacineco.events.ActualizarEstadoTarjeta;
import co.com.sofka.cineco.tarjetacineco.events.BeneficioAgregado;
import co.com.sofka.cineco.tarjetacineco.events.TarjetaCinecoCreada;
import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Optional;
import java.util.Set;

public class TarjetaCineco extends AggregateEvent<TarjetaCinecoId> {

    protected Descripcion descripcion;
    protected Estado estado;

    protected Set<Beneficio> beneficios;


    public TarjetaCineco(TarjetaCinecoId entityId, Descripcion descripcion, Estado estado) {
        super(entityId);
        appendChange(new TarjetaCinecoCreada(entityId, descripcion, estado)).apply();
    }

    private TarjetaCineco(TarjetaCinecoId entityId){
        super(entityId);
        subscribe(new TarjetaCinecoChange(this));
    }

    public void actualizarEstadoTarjeta(TarjetaCinecoId entityId,  Estado estado){
        appendChange(new ActualizarEstadoTarjeta(entityId, estado)).apply();
    }

    public void agregarBeneficio(BeneficioId entityId, co.com.sofka.cineco.beneficio.values.Descripcion descripcion , Descuento descuento){
        appendChange(new BeneficioAgregado(entityId, descripcion, descuento)).apply();
    }

    public Optional<Beneficio> getBeneficioPorId(BeneficioId entityId){
        return beneficios
                .stream()
                .filter(beneficio -> beneficio.identity().equals(entityId))
                .findFirst();
    }

    public Estado getEstado() {
        return estado;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Set<Beneficio> getBeneficios() {
        return beneficios;
    }
}
