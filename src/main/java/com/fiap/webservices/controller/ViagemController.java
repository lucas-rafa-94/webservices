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
    ViagemService viagemService;

    @PostMapping
    public ResponseViagem insert(@RequestBody Viagem viagem){
         return viagemService.criaViagem(viagem);
    }

    @GetMapping("/getAll")
    public List<Viagem> getAllViagem(){
        return viagemService.findAll();
    }

    @GetMapping
    public Viagem getViagem(@RequestParam String id){
        return viagemService.findById(id);
    }

    @PostMapping("/update")
    public Viagem update(@RequestBody Viagem viagem){
        viagemService.update(viagem);
        return viagem;
    }
}
