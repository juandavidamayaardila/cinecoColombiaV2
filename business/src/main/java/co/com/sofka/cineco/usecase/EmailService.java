package co.com.sofka.cineco.usecase;

import co.com.sofka.cineco.cliente.values.IdentificacionCliente;

public interface EmailService {

    void enviarCorreo(IdentificacionCliente clienteId, String body);
}
