package model;

public class ResultadoRegla {
    private final RiskLevel nivelRiesgo;
    private final String mensaje;

    public ResultadoRegla(RiskLevel nivelRiesgo, String mensaje) {
        this.nivelRiesgo = nivelRiesgo;
        this.mensaje = mensaje;
    }
    //La regla no cambia
    public static ResultadoRegla ok(String mensaje){
        return new ResultadoRegla(null, mensaje);
    }
    public static ResultadoRegla subir(String mensaje){
        return new ResultadoRegla(RiskLevel.MEDIO, mensaje);
    }
    public static ResultadoRegla rechazado(String mensaje){
        return new ResultadoRegla(RiskLevel.RECHAZADO, mensaje);
    }
    public RiskLevel getNivelRiesgo() {
        return nivelRiesgo;
    }
    public String getMensaje() {
        return mensaje;
    }
}
