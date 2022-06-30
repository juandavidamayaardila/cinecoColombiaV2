package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.cliente.comandos.CrearCliente;
import co.com.sofka.cineco.cliente.events.ClienteCreado;
import co.com.sofka.cineco.cliente.values.Email;
import co.com.sofka.cineco.cliente.values.IdentificacionCliente;
import co.com.sofka.cineco.cliente.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
final
class CrearClienteUseCaseTest {

    @InjectMocks
    CrearClienteUseCase useCase;
    @Test
    public void crearCliente(){
        IdentificacionCliente entityId = IdentificacionCliente.of(IdentificacionCliente.Type.CC,"1094");
        Nombre nombre = new Nombre("juan");
        Email email = new Email("juan@gmail.com");
        var command = new CrearCliente( entityId,  nombre,  email);

       var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
               .orElseThrow()
               .getDomainEvents();

       var event = (ClienteCreado)events.get(0);
        Assertions.assertEquals("juan", event.getNombre().value());


    }
}