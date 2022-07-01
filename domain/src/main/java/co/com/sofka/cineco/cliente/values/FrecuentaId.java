package co.com.sofka.cineco.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class FrecuentaId extends Identity {

    public FrecuentaId() {
    }

    private FrecuentaId(String id) {
        super(id);
    }

    public static FrecuentaId of(String id) {
        return new FrecuentaId(id);
    }
}
