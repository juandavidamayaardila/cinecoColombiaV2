package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.tarjetacineco.comandos.CrearTarjeta;
import co.com.sofka.cineco.tarjetacineco.events.TarjetaCinecoCreada;
import co.com.sofka.cineco.tarjetacineco.values.Descripcion;
import co.com.sofka.cineco.tarjetacineco.values.Estado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearTarjetaCinecoTest {

    @InjectMocks
    CrearTarjetaCineco useCase;
    @Test
    public void crearTarjeta(){

        Descripcion descripcion = new Descripcion("Tarjeta primium");
        Estado estado = new Estado(Boolean.TRUE);
        var command = new CrearTarjeta( descripcion,  estado);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TarjetaCinecoCreada)events.get(0);
        Assertions.assertEquals("Tarjeta primium", event.getDescripcion().value());
    }
}