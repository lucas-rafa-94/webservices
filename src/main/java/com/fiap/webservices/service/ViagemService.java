package com.fiap.webservices.service;

import com.fiap.webservices.models.business.ResponseViagem;
import com.fiap.webservices.models.canonical.Carro;
import com.fiap.webservices.models.canonical.Viagem;
import com.fiap.webservices.repository.CarroRepository;
import com.fiap.webservices.repository.ViagemRepository;
import com.fiap.webservices.client.ViagemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

import static com.fiap.webservices.models.canonical.Status.*;

@Service
public class ViagemService {

    @Autowired
    ViagemRepository viagemRepository;

    @Autowired
    CarroRepository carroRepository;

    public ResponseViagem criaViagem(Viagem viagem){

        ViagemClient viagemClient = new ViagemClient();
        ResponseViagem responseViagem = new ResponseViagem();
        String id = viagem.getCarro().getChassi() + viagem.getCarro().getUsuario().getCpf() + LocalTime.now().toString().replace(":","").replace(".","");

        responseViagem.setIdViagem(id);
        viagem.setViagem(id);
        viagem.setStatus(EM_ANDAMENTO.name());
        viagem.setValor(viagemClient.calculaValor(viagem.getLocalizacaoUsuario(), viagem.getLocalizacaoCarro()));
        viagemRepository.save(viagem);

        Carro carro = viagem.getCarro();
        carro.setStatus(PENDENTE.name());
        carro.setUsuario(viagem.getCarro().getUsuario());
        carroRepository.save(carro);

        return responseViagem;
    }

    public void update(Viagem viagem){

        if(viagem.getStatus().equals(CONCLUIDO.name())){
            Carro carro = viagem.getCarro();
            carro.setLocalizacao(viagem.getLocalizacaoUsuario());
            carro.setUsuario(null);
            carro.setStatus(DISPONIVEL.name());

            carroRepository.save(carro);
        }
        viagemRepository.save(viagem);
    }

    public Viagem findById(String id){
        return viagemRepository.findById(id).orElseGet(null);
    }

    public List<Viagem> findAll(){
        return viagemRepository.findAll();
    };

}
