package com.example.loyalty.Model;

public class CodigoPontos {
    private String idCodigo;
    private Integer idEmpresa;
    private Integer validado;
    private Integer numeroDePontos;
    private Double valorDaCompra;

    public String getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(String idCodigo) {
        this.idCodigo = idCodigo;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getValidado() {
        return validado;
    }

    public void setValidado(Integer validado) {
        this.validado = validado;
    }

    public Integer getNumeroPontos() {
        return numeroDePontos;
    }

    public void setNumeroPontos(Integer numeroDePontos) {
        this.numeroDePontos = numeroDePontos;
    }

    public Double getValorCompra() {
        return valorDaCompra;
    }

    public void setValorCompra(Double valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }
}
