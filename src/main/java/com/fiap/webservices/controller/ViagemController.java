package com.fiap.webservices.controller;

import com.fiap.webservices.models.business.ResponseCall;
import com.fiap.webservices.models.business.ResponseViagem;
import com.fiap.webservices.models.canonical.Viagem;
import com.fiap.webservices.repository.ViagemRepository;
import com.fiap.webservices.service.ViagemService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @PostMapping
    public ResponseViagem insert(@RequestBody Viagem viagem){
        return viagemService.criaViagem(viagem);
    }

    @GetMapping("/")
    public List<Viagem> getAllViagens(){
        return viagemService.findAll();
    }

    @GetMapping("/{id}")
    public Viagem getViagem(@PathVariable String id){
        return viagemService.findById(id);
    }

    @PutMapping("/")
    public Viagem update(@RequestBody Viagem viagem){
        viagemService.update(viagem);
        return viagem;
    }
}
