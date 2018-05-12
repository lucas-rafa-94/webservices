package com.fiap.webservices.service;

import com.fiap.webservices.models.business.ResponseCall;
import com.fiap.webservices.models.business.ResponseViagem;
import com.fiap.webservices.models.canonical.Carro;
import com.fiap.webservices.models.canonical.Viagem;
import com.fiap.webservices.repository.ViagemRepository;
import com.fiap.webservices.uitils.ViagemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ViagemService {

    @Autowired
    ViagemRepository viagemRepository;

    @Autowired
    CarroService carroService;

    public ResponseViagem criaViagem(Viagem viagem){
        ViagemUtils viagemUtils = new ViagemUtils();
        ResponseViagem responseViagem = new ResponseViagem();
        String id = viagem.getCarro().getChassi() + viagem.getCarro().getUsuario().getCpf() + LocalTime.now().toString().replace(":","").replace(".","");
        try{
            responseViagem.setIdViagem(id);
            viagem.setViagem(id);
            viagem.setValor(viagemUtils.calculaValor(viagem.getLocalizacaoUsuario(), viagem.getLocalizacaoCarro()));
            viagemRepository.save(viagem);
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseViagem;
    }

    public void update(Viagem viagem){

        if(viagem.getStatus().equals("CONCLUIDO")){
            Carro carro = new Carro();

            carro = carroService.findByChassi(viagem.getCarro().getChassi());
            carro.setLocalizacao(viagem.getLocalizacaoUsuario());
            carro.setUsuario(null);
            carro.setStatus("DISPONIVEL");

            carroService.criaCarro(carro);
        }
        viagemRepository.save(viagem);
    }

    public Viagem findById(String id){
        return viagemRepository.findByViagem(id);
    }

    public List<Viagem> findAll(){
        return viagemRepository.findAll();
    };

}
