package model;

public class ContextoReglas {
    private DatosContables datosContables;
    private final HistorialPagos historialPagos;
    private VerificacionLegal verificacionLegal;
    private RiskRequest riskRequest;

    public ContextoReglas(DatosContables datosContables, HistorialPagos historialPagos,
            VerificacionLegal verificacionLegal, RiskRequest riskRequest) {
        this.datosContables = datosContables;
        this.historialPagos = historialPagos;
        this.verificacionLegal = verificacionLegal;
        this.riskRequest = riskRequest;
    }
    public DatosContables DatosContables() {
        return datosContables;
    }
    public HistorialPagos HistorialPagos() {
        return historialPagos;
    }
    public VerificacionLegal VerificacionLegal() {
        return verificacionLegal;
    }
    public RiskRequest RiskRequest() {
        return riskRequest;
    }
}
