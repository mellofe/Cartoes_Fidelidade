package com.example.loyalty.Model;

public class Empresa {
    private String idEmpresa;
    private String login;
    private Integer inadimplente;
    private Integer precoPonto;

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getInadimplente() {
        return inadimplente;
    }

    public void setInadimplente(Integer inadimplente) {
        this.inadimplente = inadimplente;
    }

    public Integer getPrecoPonto() {
        return precoPonto;
    }

    public void setPrecoPonto(Integer precoPonto) {
        this.precoPonto = precoPonto;
    }
}
