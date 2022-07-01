package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.pelicula.comandos.CrearPelicula;
import co.com.sofka.cineco.pelicula.events.PeliculaCreada;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.cineco.pelicula.values.Sinopsis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearPeliculaUseCaseTest {


    @InjectMocks
    CrearPeliculaUseCase useCase;

    @Test
    public void crearPelicula() {


        Nombre nombre = new Nombre("Rapido y furioso");
        Sinopsis sinopsis = new Sinopsis("Pelicula de accion y carreras de carros");

        var command = new CrearPelicula(nombre, sinopsis);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PeliculaCreada) events.get(0);
        Assertions.assertEquals("Rapido y furioso", event.getNombre().value());

    }
}