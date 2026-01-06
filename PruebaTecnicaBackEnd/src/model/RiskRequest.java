package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RiskRequest {
    private String empresaId;
    private BigDecimal montoSolicitado;
    private ProductoFinanciero productoFinanciero;
    private LocalDate fechaSolicitud;

    public RiskRequest(String empresaId, LocalDate fechaSolicitud, ProductoFinanciero productoFinanciero, BigDecimal montoSolicitado) {
        this.empresaId = empresaId;
        this.fechaSolicitud = fechaSolicitud;
        this.productoFinanciero = productoFinanciero;
        this.montoSolicitado = montoSolicitado;
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(String empresaId) {
        this.empresaId = empresaId;
    }

    public BigDecimal getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(BigDecimal montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public ProductoFinanciero getProductoFinanciero() {
        return productoFinanciero;
    }

    public void setProductoFinanciero(ProductoFinanciero productoFinanciero) {
        this.productoFinanciero = productoFinanciero;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
