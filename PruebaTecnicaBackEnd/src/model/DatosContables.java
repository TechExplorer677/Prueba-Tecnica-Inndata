package model;

import java.math.BigDecimal;

public class DatosContables {
    private BigDecimal ventasPromedio;
    private BigDecimal pasivos;
    private BigDecimal activos;
    public DatosContables(BigDecimal ventasPromedio, BigDecimal pasivos, BigDecimal activos) {
        this.ventasPromedio = ventasPromedio;
        this.pasivos = pasivos;
        this.activos = activos;
    }
    public BigDecimal getVentasPromedio() {
        return ventasPromedio;
    }

    public BigDecimal getPasivos() {
        return pasivos;
    }

    public BigDecimal getActivos() {
        return activos;
    }
}
