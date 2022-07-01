package co.com.sofka.cineco.cliente.comandos;

import co.com.sofka.cineco.cliente.events.TarjetaAgregada;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.tarjetacineco.TarjetaCineco;
import co.com.sofka.cineco.tarjetacineco.values.Beneficio;
import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import co.com.sofka.cineco.tarjetacineco.values.TarjetaCinecoId;
import co.com.sofka.domain.generic.Command;

import java.util.List;
import java.util.Set;

public class AgregarTarjeta extends Command {

    private final IdentificacionCliente entityId;

    private Descripcion descripcion;
    private Estado estado;
    private List<Beneficio> beneficios;

    public AgregarTarjeta(IdentificacionCliente entityId, Descripcion descripcion, Estado estado,
                          List<Beneficio> beneficios){
        this.entityId = entityId;
        this.descripcion = descripcion;
        this.estado = estado;
        this.beneficios = beneficios;

    }

    public IdentificacionCliente getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }
}
