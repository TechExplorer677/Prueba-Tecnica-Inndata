package rules;

import model.ContextoReglas;
import model.ResultadoRegla;

public class ReglaEmpresaNueva implements ReglaRiesgo{
    @Override
    public ResultadoRegla evaluar(ContextoReglas contexto) {
        int antiguedadMeses = contexto.HistorialPagos().getMesesAntiguedad();
         if (antiguedadMeses < 18) {
            return ResultadoRegla.subir("La empresa es nueva (menos de 18 meses de antiguedad).");
        } else {
            return ResultadoRegla.ok("La empresa tiene suficiente antigüedad.");
        }
    }

}
