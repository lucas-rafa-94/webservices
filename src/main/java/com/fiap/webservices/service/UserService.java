package com.fiap.webservices.service;

import com.fiap.webservices.models.business.ResponseCall;
import com.fiap.webservices.models.canonical.Usuario;
import com.fiap.webservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    private ResponseCall responseCall;

    public ResponseCall validaLogin(String email, String password){
         return responseCall;

    }

    public ResponseCall criaUser(Usuario usuario){
        ResponseCall responseCall = new ResponseCall();
        try{
            userRepository.save(usuario);
            responseCall.setResponse("Sucesso");
            responseCall.setDescricao("Usuario criado com sucesso");
        }catch (Exception e){
            responseCall.setResponse("Falha");
            responseCall.setDescricao(e.getMessage());
        }
        return responseCall;
    }

    public Usuario findByEmailAndPassword(String email, String password){
        return userRepository.findByEmailEqualsAndPassword(email, password);
    }
}
