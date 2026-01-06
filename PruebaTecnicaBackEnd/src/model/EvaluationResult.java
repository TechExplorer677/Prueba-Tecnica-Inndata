package model;

import java.awt.*;
import java.util.List;

public class EvaluationResult {
    private RiskLevel riskLevel;
    private String mensajeFinal;
    private List<String> reglasAplicadas;

    public EvaluationResult(RiskLevel riskLevel, String mensajeFinal, List<String> reglasAplicadas) {
        this.riskLevel = riskLevel;
        this.mensajeFinal = mensajeFinal;
        this.reglasAplicadas = reglasAplicadas;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public String getMensajeFinal() {
        return mensajeFinal;
    }

    public List<String> getReglasAplicadas() {
        return reglasAplicadas;
    }

}
