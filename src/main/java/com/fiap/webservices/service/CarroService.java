package com.fiap.webservices.service;

import com.fiap.webservices.models.canonical.Carro;
import com.fiap.webservices.models.business.ResponseCall;

import com.fiap.webservices.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    CarroRepository carroRepository;

    public ResponseCall criaCarro(Carro carro){
        ResponseCall responseCall = new ResponseCall();
        try{
            carroRepository.save(carro);
            responseCall.setResponse("Sucesso");
            responseCall.setDescricao("Carro criado com sucesso");
        }catch (Exception e){
            responseCall.setResponse("Falha");
            responseCall.setDescricao(e.getMessage());
        }
        return responseCall;
    }

    public Carro findByChassi(String chassi){
        return carroRepository.findById(chassi).orElse(null);
    }

    public List<Carro> getAll(){
        return carroRepository.findAll();
    }
}
