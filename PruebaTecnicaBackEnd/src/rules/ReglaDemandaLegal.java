package rules;

import model.ContextoReglas;
import model.ResultadoRegla;

public class ReglaDemandaLegal implements ReglaRiesgo {

    @Override
    public ResultadoRegla evaluar(ContextoReglas contexto) {
        boolean procesosLegales = contexto.VerificacionLegal().isProcesosLegales();
        boolean embargos = contexto.VerificacionLegal().isEmbargos();

        if (embargos){
            return ResultadoRegla.rechazado("La empresa tiene embargos legales activos.");
        } else if (procesosLegales) {
            return ResultadoRegla.rechazado("La empresa está involucrada en procesos legales.");
        } else {
            return ResultadoRegla.ok("La empresa no tiene problemas legales.");
        }
    }

}
