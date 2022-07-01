package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.pelicula.comandos.AgregarEstudio;
import co.com.sofka.cineco.pelicula.events.EstudioAgregado;
import co.com.sofka.cineco.pelicula.events.PeliculaCreada;
import co.com.sofka.cineco.pelicula.values.NombreEstudio;
import co.com.sofka.cineco.pelicula.values.NombrePelicula;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.cineco.pelicula.values.Sinopsis;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEstuioPeliculaUseCaseTest {

    @InjectMocks
    private AgregarEstuioPeliculaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarEstudioApelicula() {
        var peliculaId = PeliculaId.of("123");
        NombreEstudio nombre = new NombreEstudio("Marvel");
        Sinopsis sinopsis = new Sinopsis("No apta para niños");
        var command = new AgregarEstudio(peliculaId, nombre);

        when(repository.getEventsBy("123")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPeliculaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EstudioAgregado) events.get(0);
        Assertions.assertEquals("Marvel", event.getNombreEstudio().value());
    }

    private List<DomainEvent> history() {
        var nombre = new NombrePelicula("Rapido");
        var sinopsis = new Sinopsis("Pelicula de carros y accion");

        var event = new PeliculaCreada(
                nombre,
                sinopsis
        );
        // event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}