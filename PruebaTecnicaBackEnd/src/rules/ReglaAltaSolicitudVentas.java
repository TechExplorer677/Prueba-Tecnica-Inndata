package rules;

import model.ContextoReglas;
import model.ResultadoRegla;

import java.math.BigDecimal;

public class ReglaAltaSolicitudVentas implements  ReglaRiesgo{
    @Override
    public ResultadoRegla evaluar(ContextoReglas contexto) {
        BigDecimal montoSolicitado = contexto.RiskRequest().getMontoSolicitado();
        BigDecimal ventasPromedio = contexto.DatosContables().getVentasPromedio();

        if (montoSolicitado.compareTo(ventasPromedio)>0){
            return ResultadoRegla.subir("El monto solicitado es mayor a las ventas promedio de la empresa.");
        } else {
            return ResultadoRegla.ok("El monto solicitado es aceptable en relación a las ventas promedio de la empresa.");
        }
    }
}
