package com.fiap.webservices.models.canonical;

import com.fiap.webservices.models.business.Localizacao;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Viagem {
    @Id
    private String viagem;
    private String status;
    private double valor;
    private Localizacao localizacaoCarro;
    private Localizacao localizacaoUsuario;
    private Carro carro;

    public Viagem(String viagem, String status, double valor, Localizacao localizacaoCarro, Localizacao localizacaoUsuario, Carro carro) {
        this.viagem = viagem;
        this.status = status;
        this.valor = valor;
        this.localizacaoCarro = localizacaoCarro;
        this.localizacaoUsuario = localizacaoUsuario;
        this.carro = carro;
    }

    public Viagem() {
    }

    public String getViagem() {
        return viagem;
    }

    public void setViagem(String id) {
        this.viagem = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Localizacao getLocalizacaoCarro() {
        return localizacaoCarro;
    }

    public void setLocalizacaoCarro(Localizacao localizacaoCarro) {
        this.localizacaoCarro = localizacaoCarro;
    }

    public Localizacao getLocalizacaoUsuario() {
        return localizacaoUsuario;
    }

    public void setLocalizacaoUsuario(Localizacao localizacaoUsuario) {
        this.localizacaoUsuario = localizacaoUsuario;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
