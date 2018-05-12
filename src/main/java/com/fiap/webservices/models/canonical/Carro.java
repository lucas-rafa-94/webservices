package com.fiap.webservices.models.canonical;

import com.fiap.webservices.models.business.Localizacao;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Carro {

    private String marca;
    private String modelo;
    @Id
    private int chassi;
    private String status;
    private Usuario usuario;
    private Localizacao localizacao;

    public Carro(String marca, String modelo, int chassi, String status, Usuario usuario, Localizacao localizacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
        this.status = status;
        this.usuario = usuario;
        this.localizacao = localizacao;
    }

    public Carro() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}
