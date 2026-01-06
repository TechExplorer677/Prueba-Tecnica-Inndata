package engine;

import model.*;
import providers.DatosContablesProvider;
import providers.HistorialPagosProvider;
import providers.VerificacionLegalProvider;
import rules.ReglaRiesgo;

import java.util.ArrayList;
import java.util.List;

public class OrdenarisRiskEngine {
    private final DatosContablesProvider datosContablesProvider;
    private final HistorialPagosProvider historialPagosProvider;
    private final VerificacionLegalProvider verificacionLegalProvider;
    private final List<ReglaRiesgo> reglasRiesgo;

    public OrdenarisRiskEngine(DatosContablesProvider datosContablesProvider,
                               HistorialPagosProvider historialPagosProvider,
                               VerificacionLegalProvider verificacionLegalProvider,
                               List<ReglaRiesgo> reglasRiesgo) {
        this.datosContablesProvider = datosContablesProvider;
        this.historialPagosProvider = historialPagosProvider;
        this.verificacionLegalProvider = verificacionLegalProvider;
        this.reglasRiesgo = reglasRiesgo;
    }
    public EvaluationResult evaluar(RiskRequest request){
        //obtener datos de los providers
        DatosContables datosContables = datosContablesProvider.obtenerDatosContables(request.getEmpresaId());
        HistorialPagos historialPagos = historialPagosProvider.obtenerHistorialPagos(request.getEmpresaId());
        VerificacionLegal verificacionLegal = verificacionLegalProvider.verificarLegalidad(request.getEmpresaId());

        //crear contexto de reglas
        ContextoReglas contexto = new ContextoReglas(datosContables, historialPagos, verificacionLegal, request);

        //riesgo inicial
        RiskLevel nivelActual = RiskLevel.BAJO;
        List<String> mensajes = new ArrayList<>();

        //ejecutar reglas
        for (ReglaRiesgo regla : reglasRiesgo){
            ResultadoRegla resultado = regla.evaluar(contexto);
            mensajes.add(resultado.getMensaje());
          //rechazar si aplica
            if (resultado.getNivelRiesgo() == RiskLevel.RECHAZADO){
                return new EvaluationResult(RiskLevel.RECHAZADO,"Regla determiante: " + resultado.getMensaje(), mensajes);
            }
            //subir nivel si aplica
            if (resultado.getNivelRiesgo() != null) {
                nivelActual =subirNivel(nivelActual);
            }

        }
        String motivoFinal;
        if (nivelActual == RiskLevel.BAJO){
            motivoFinal = "Evaluacion Favorable sin reglas";
        }else{
            motivoFinal = "Resultado determinado por combinacion de reglas";
        }
        return new EvaluationResult(nivelActual,motivoFinal, mensajes);
    }
    //subor nivel de riesgo
    private RiskLevel subirNivel(RiskLevel nivelActual) {
        return switch (nivelActual) {
            case BAJO -> RiskLevel.MEDIO;
            case MEDIO -> RiskLevel.ALTO;
            case ALTO -> RiskLevel.ALTO;
            default -> nivelActual;
        };
    }
}
