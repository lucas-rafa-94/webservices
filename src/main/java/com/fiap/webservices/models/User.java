package com.fiap.webservices.models;

import org.springframework.data.annotation.Id;

import java.io.Serializable;


public class User implements Serializable{
    @Id
    private String cpf;
    private String email;
    private String nome;
    private String password;

    public User(String cpf, String email, String nome, String password) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.password = password;
    }

    public User() { }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
