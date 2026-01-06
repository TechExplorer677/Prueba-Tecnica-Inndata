package rules;

import model.ContextoReglas;
import model.ResultadoRegla;

public class ReglaDeudaActiva implements ReglaRiesgo{
    @Override
    public ResultadoRegla evaluar(ContextoReglas contexto) {
        int diasDeuda = contexto.HistorialPagos().getDiasDeuda();
        if (diasDeuda > 90) {
            return  ResultadoRegla.rechazado("La empresa tiene una deuda activa mayor a 90 días.");
        } else {
            return ResultadoRegla.ok("La empresa tiene una deuda activa aceptable.");
        }
    }
}
