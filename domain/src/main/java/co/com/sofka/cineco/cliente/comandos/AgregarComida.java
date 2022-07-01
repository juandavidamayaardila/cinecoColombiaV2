package co.com.sofka.cineco.cliente.comandos;

import co.com.sofka.cineco.cliente.values.ComidaId;
import co.com.sofka.cineco.cliente.values.DescripcionComida;
import co.com.sofka.domain.generic.Command;

public class AgregarComida extends Command {

    private final ComidaId comidaId;
    private final DescripcionComida descripcionComida;

    public AgregarComida(ComidaId entityId, DescripcionComida descripcionComida){
        this.comidaId = entityId;
        this.descripcionComida = descripcionComida;
    }

    public ComidaId getComidaId() {
        return comidaId;
    }

    public DescripcionComida getDescripcionComida() {
        return descripcionComida;
    }
}
