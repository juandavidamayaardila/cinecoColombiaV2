package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.sala.Asiento;
import co.com.sofka.cineco.sala.SalaChange;
import co.com.sofka.cineco.sala.comandos.CrearSala;
import co.com.sofka.cineco.sala.events.SalaCreada;
import co.com.sofka.cineco.sala.values.AsientoId;
import co.com.sofka.cineco.sala.values.Descripcion;
import co.com.sofka.cineco.sala.values.TipoSala;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearSalaUseCaseTest {

    @InjectMocks
    CrearSalaUseCase useCase;
    @Test
    public void crearSala(){

        TipoSala tipoSala = new TipoSala("2k full HD");
        //TipoSala tipoSala = new TipoSala("2k"); //caso para probar la regla de negocio falla
        Asiento asiento1 = new Asiento( new AsientoId(), new Descripcion("primera fila"));
        Asiento asiento2 = new Asiento( new AsientoId(), new Descripcion("segunda fila"));
        Asiento asiento3 = new Asiento( new AsientoId(), new Descripcion("tercera fila"));
        List<Asiento> listAsiento = new ArrayList<>();
        listAsiento.add(asiento1);
        listAsiento.add(asiento2);
        listAsiento.add(asiento3);

        var command = new CrearSala( tipoSala, listAsiento);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (SalaCreada)events.get(0);
        Assertions.assertEquals("2k full HD", event.getTipoSala().value());


    }
}