package model;

public class HistorialPagos {
    private int diasDeuda;
    private boolean pagosExcelentes;
    private int mesesAntiguedad;
    public HistorialPagos(int diasDeuda, boolean pagosExcelentes, int mesesAntiguedad) {
        this.diasDeuda = diasDeuda;
        this.pagosExcelentes = pagosExcelentes;
        this.mesesAntiguedad = mesesAntiguedad;
    }
    public int getDiasDeuda() {
        return diasDeuda;
    }

    public boolean isPagosExcelentes() {
        return pagosExcelentes;
    }

    public int getMesesAntiguedad() {
        return mesesAntiguedad;
    }
}
