package co.com.sofka.cineco.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cineco.beneficio.comandos.ActualizarDescuento;
import co.com.sofka.cineco.beneficio.events.DescuentoActualizdo;
import co.com.sofka.cineco.beneficio.values.BeneficioId;
import co.com.sofka.cineco.beneficio.values.Descuento;
import co.com.sofka.cineco.cliente.events.ClienteCreado;
import co.com.sofka.cineco.cliente.values.Email;
import co.com.sofka.cineco.cliente.values.Nombre;
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
class ActualizarDescuentoBeneficioUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ActualizarDescuentoBeneficioUseCase usecase;

    @Test
    public void actualizarDescuentoBeneficio(){

        BeneficioId entityId = new BeneficioId();
        Descuento descuento = new Descuento("40000");
        var command = new ActualizarDescuento( entityId,  descuento);

        when(repository.getEventsBy(entityId.value())).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DescuentoActualizdo)events.get(0);
        Assertions.assertEquals("40000",event.getDescuento().value());

    }


    private List<DomainEvent> history(){
        BeneficioId entityId = new BeneficioId();
        Descuento descuento = new Descuento("80000");
        return List.of(
                new DescuentoActualizdo(entityId,descuento)
        );
    }
}