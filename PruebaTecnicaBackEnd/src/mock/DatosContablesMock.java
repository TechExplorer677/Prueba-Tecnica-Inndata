package mock;

import model.DatosContables;
import providers.DatosContablesProvider;

import java.math.BigDecimal;

public class DatosContablesMock implements DatosContablesProvider {
    @Override
    public model.DatosContables obtenerDatosContables(String idEmpresa) {
        // Retorna datos contables ficticios para pruebas
        return new DatosContables(
                new BigDecimal("100000"),// ventasPromedio
                new BigDecimal("50000"), // pasivos
                new BigDecimal("10000")// activos
        );
    }
}
