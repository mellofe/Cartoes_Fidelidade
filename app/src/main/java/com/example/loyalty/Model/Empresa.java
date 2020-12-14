package com.example.loyalty.Model;

public class Empresa {
    private int idEmpresa;
    private String login;
    private int inadimplente;
    private double precoPonto;

    public Empresa(int idEmpresa,String login, int inadimplente, int precoPonto ){
        this.idEmpresa = idEmpresa;
        this.login = login;
        this.inadimplente = inadimplente;
        this.precoPonto = precoPonto;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setIdEmpresa(int idEmpresa){
        this.idEmpresa = idEmpresa;
    }

    public int getInadimplente() {
        return inadimplente;
    }

    public void setInadimplente(int inadimplente) {
        this.inadimplente = inadimplente;
    }

    public double getPrecoPonto() {
        return precoPonto;
    }

    public void setPrecoPonto(double precoPonto) {
        this.precoPonto = precoPonto;
    }
}
