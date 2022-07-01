package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.cliente.events.ClienteCreado;
import co.com.sofka.cineco.cliente.values.Email;
import co.com.sofka.cineco.cliente.values.Nombre;
import co.com.sofka.cineco.pelicula.comandos.ActualizarHorarioPelicula;
import co.com.sofka.cineco.pelicula.events.PeliculaCreada;
import co.com.sofka.cineco.pelicula.values.Horario;
import co.com.sofka.cineco.pelicula.values.PeliculaId;
import co.com.sofka.cineco.pelicula.values.Sinopsis;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarHorarioPeliculaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ActualizarHorarioPeliculaUseCase usecase;

    @Test
    public void actualizarHorarioPelicula() {

        PeliculaId entityId = new PeliculaId();
        Horario horario = new Horario("En la noche");

        var command = new ActualizarHorarioPelicula(entityId, horario);

        when(repository.getEventsBy(entityId.value())).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


    }

    private List<DomainEvent> history() {

        co.com.sofka.cineco.cliente.values.Nombre nombre = new Nombre("Its");
        Horario horario = new Horario("En la mañana");
        Sinopsis sinopsis = new Sinopsis("Pelicula no apta para niños");

        return List.of(
                new PeliculaCreada(nombre, sinopsis)
        );
    }
}