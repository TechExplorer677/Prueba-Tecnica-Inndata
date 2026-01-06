package mock;

import model.HistorialPagos;
import providers.HistorialPagosProvider;

public class HistorialPagosMock implements HistorialPagosProvider {
    @Override
    public HistorialPagos obtenerHistorialPagos(String idEmpresa) {
        // Retorna un historial de pagos ficticio para pruebas
        return new HistorialPagos(
                0,/* dias de deuda*/
                true,/* true indica buen historial de pagos*/
                48); /*Antiguedad de la empresa en meses*/
    }
}
