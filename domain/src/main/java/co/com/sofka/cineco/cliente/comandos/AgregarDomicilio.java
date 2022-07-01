package co.com.sofka.cineco.cliente.comandos;

import co.com.sofka.cineco.cliente.values.Domicilio;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.domain.generic.Command;

public class AgregarDomicilio extends Command {

    private final IdentificacionCliente entityId;
    private final Domicilio domicilio;

    public AgregarDomicilio(IdentificacionCliente entityId, Domicilio domicilio) {
        this.entityId = entityId;
        this.domicilio = domicilio;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public IdentificacionCliente getEntityId() {
        return entityId;
    }
}
