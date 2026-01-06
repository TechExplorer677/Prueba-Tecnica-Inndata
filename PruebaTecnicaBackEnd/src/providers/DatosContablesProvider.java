package providers;

import model.DatosContables;

public interface DatosContablesProvider {
    DatosContables obtenerDatosContables(String idEmpresa);
}
