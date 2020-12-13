package com.example.loyalty.Model;

public class Cliente {
    private String nome;
    private String login;

    public Cliente(String nome, String login){
        this.nome = nome;
        this.login = login;
    }
    public String getIdCliente() {
        return nome;
    }

    public void setIdCliente(String idCliente) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
