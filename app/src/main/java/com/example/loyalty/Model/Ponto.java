package com.example.loyalty.Model;

public class Ponto {
    private String idCliente;
    private int idEmpresa;
    private int numeroTotalPontos;

    public void Pontos(String idCliente, int idEmpresa, int numeroTotalPontos){
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
        this.numeroTotalPontos+= numeroTotalPontos;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getNumeroTotalPontos() {
        return numeroTotalPontos;
    }

    public void setNumeroTotalPontos(int numeroTotalPontos) {
        this.numeroTotalPontos = numeroTotalPontos;
    }
}
