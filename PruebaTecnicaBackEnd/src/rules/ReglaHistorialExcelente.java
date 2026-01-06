package rules;

import model.ContextoReglas;
import model.ResultadoRegla;

public class ReglaHistorialExcelente implements ReglaRiesgo{
    @Override
    public ResultadoRegla evaluar(ContextoReglas contexto) {
        boolean historialExcelente = contexto.HistorialPagos().isPagosExcelentes();
        if (historialExcelente) {
            return ResultadoRegla.ok("La empresa tiene un historial de pagos excelente sin días de atraso.");
        } else {
            return ResultadoRegla.ok("La empresa no tiene un historial de pagos excelente.");
        }
    }
}
