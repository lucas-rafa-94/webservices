package com.fiap.webservices.models.business;

import org.springframework.stereotype.Service;

@Service
public class ResponseCall {

    public String response;
    public String descricao;

    public ResponseCall(String response, String descricao) {
        this.response = response;
        this.descricao = descricao;
    }

    public ResponseCall() { }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
