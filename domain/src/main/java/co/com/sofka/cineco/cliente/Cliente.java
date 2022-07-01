package co.com.sofka.cineco.cliente;

import co.com.sofka.cineco.cliente.events.*;
import co.com.sofka.cineco.cliente.values.*;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Cliente extends AggregateEvent<IdentificacionCliente> {

    protected Nombre nombre;
    protected Email email;
    protected Domicilio domicilio;
    protected FechaCumplenos fechaCumplenos;

    protected TarjetaCinecoId tarjetaCineco;

    protected Set<Preferencia> preferencias;

    protected Set<DiasFrecuenta> frecuentas;


    public Cliente(IdentificacionCliente entityId, Nombre nombre, Email email) {
        super(entityId);
        appendChange(new ClienteCreado(nombre, email)).apply();
    }

    private Cliente(IdentificacionCliente entityId) {
        super(entityId);
        subscribe(new ClienteChange(this));
    }

    public static Cliente from(IdentificacionCliente entityId, List<DomainEvent> eventsBy) {
        var cliente = new Cliente(entityId);
        eventsBy.forEach(cliente::applyEvent);
        return cliente;
    }


    public void cambiarNombre(IdentificacionCliente entityId, Nombre nombre) {
        appendChange(new NombreCambiado(entityId, nombre)).apply();
    }

    public void agregarTarjeta( TarjetaCinecoId tarjeta) {
        appendChange(new TarjetaAgregada(tarjeta)).apply();

    }

    public void agregarPreferencias(PreferenciaId entityId, DescripcionPreferencia descripcionPreferencia){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(descripcionPreferencia);

        appendChange(new PreferenciaAgregada( entityId,  descripcionPreferencia)).apply();
    }

    public void agregarDiasFrecuenta(FrecuentaId entityId, DescripcionFrecuenta descripcionFrecuenta){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(descripcionFrecuenta);
        appendChange(new DiasFrecuentaAgregada(entityId, descripcionFrecuenta));
    }

    public void cambiarEmail(IdentificacionCliente entityId, Email email) {
        appendChange(new EmailCambiado(entityId, email));
    }

    public void agregarDomicilio(IdentificacionCliente entityId, Domicilio domicilio) {
        appendChange(new DomicilioAgregado(entityId, domicilio));
    }

    protected Optional<Preferencia> getPreferenciaPoId(PreferenciaId edentity){
        return preferencias
                .stream()
                .filter( preferencia -> preferencia.identity().equals(edentity)).findFirst();
    }

    protected Optional<DiasFrecuenta> getFrecuentaPoId(PreferenciaId edentity){
        return frecuentas
                .stream()
                .filter( frecuenta -> frecuenta.identity().equals(edentity)).findFirst();
    }


    public Nombre nombre() {
        return nombre;
    }

    public Email email() {
        return email;
    }

    public Domicilio domicilio() {
        return domicilio;
    }

    public FechaCumplenos fechaCumplenos() {
        return fechaCumplenos;
    }

    public TarjetaCinecoId tarjetaCineco() {
        return tarjetaCineco;
    }

    public Set<DiasFrecuenta> frecuentas() {
        return frecuentas;
    }

    public Set<Preferencia> preferencias() {
        return preferencias;
    }
}
