import engine.OrdenarisRiskEngine;
import mock.DatosContablesMock;
import mock.HistorialPagosMock;
import mock.VerificacionLegalMock;
import model.EvaluationResult;
import model.ProductoFinanciero;
import model.RiskRequest;
import providers.DatosContablesProvider;
import providers.HistorialPagosProvider;
import providers.VerificacionLegalProvider;
import rules.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        //crear provider
        DatosContablesProvider datosContablesProvider = new DatosContablesMock();
        HistorialPagosProvider historialPagosProvider = new HistorialPagosMock();
        VerificacionLegalProvider verificacionLegalProvider = new VerificacionLegalMock();

        //crear reglas
        List<ReglaRiesgo> reglas = List.of(
                new ReglaDeudaActiva(),
                new ReglaAltaSolicitudVentas(),
                new ReglaEmpresaNueva(),
                new ReglaDemandaLegal(),
                new ReglaHistorialExcelente(),
                new ReglaProductoEstricto()
        );
        //crear motor
        OrdenarisRiskEngine engine = new OrdenarisRiskEngine(
                datosContablesProvider,
                historialPagosProvider,
                verificacionLegalProvider,
                reglas
        );
        //crear prueba
        RiskRequest request = new RiskRequest(
                "Empresa123",
                LocalDate.of(2025, 6, 15),
                ProductoFinanciero.LINEA_OPERATIVA,
                new BigDecimal("30000")
        );

        //Evaluar riesgo
        EvaluationResult result = engine.evaluar(request);
        //Mostrar resultado
        System.out.println("Nivel de Riesgo: " + result.getRiskLevel());
        System.out.println("Mensaje Final: " + result.getMensajeFinal());
        System.out.println("Reglas Aplicadas: " );
        for (String regla : result.getReglasAplicadas()) {
            System.out.println("- " + regla);
        }
    }
}