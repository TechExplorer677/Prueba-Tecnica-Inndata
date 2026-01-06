package rules;

import model.ContextoReglas;
import model.ProductoFinanciero;
import model.ResultadoRegla;

public class ReglaProductoEstricto implements ReglaRiesgo{
    @Override
    public ResultadoRegla evaluar(ContextoReglas contexto) {
        ProductoFinanciero productoFinanciero = contexto.RiskRequest().getProductoFinanciero();
        if (productoFinanciero == ProductoFinanciero.ARRENDAMIENTO_FINANCIERO){
            return ResultadoRegla.subir("El producto financiero es un arrendamiento financiero, el cual incrementa el riesgo.");
        } else {
            return ResultadoRegla.ok("El producto financiero no es un arrendamiento financiero.");
        }
    }
}
