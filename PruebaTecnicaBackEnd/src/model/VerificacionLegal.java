package model;

public class VerificacionLegal {
    private boolean procesosLegales;
    private boolean embargos;
    private String notas;
    public VerificacionLegal(boolean procesosLegales, boolean embargos, String notas) {
        this.procesosLegales = procesosLegales;
        this.embargos = embargos;
        this.notas = notas;
    }
    public boolean isProcesosLegales() {
        return procesosLegales;
    }
    public boolean isEmbargos() {
        return embargos;
    }
    public String getNotas() {
        return notas;
        }
}
