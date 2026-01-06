package rules;

import model.ContextoReglas;
import model.ResultadoRegla;

public interface ReglaRiesgo {
    ResultadoRegla evaluar(ContextoReglas contextoReglas);
}
