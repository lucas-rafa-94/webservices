package com.fiap.webservices.models.canonical;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Usuario implements Serializable{
    @Id
    private String cpf;
    private String email;
    private String nome;
    private String password;

    public Usuario(String cpf, String email, String nome, String password) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.password = password;
    }

    public Usuario() { }

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
