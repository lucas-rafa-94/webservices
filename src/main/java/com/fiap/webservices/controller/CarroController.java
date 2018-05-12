package com.fiap.webservices.controller;

import com.fiap.webservices.models.canonical.Carro;
import com.fiap.webservices.models.business.ResponseCall;
import com.fiap.webservices.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    CarroService carroService;

    @PostMapping
    public ResponseCall insert(@RequestBody Carro carro){
        return carroService.criaCarro(carro);
    }

    @GetMapping("/disponiveis")
    public List<Carro> carrosDisponiveis(){
        return carroService.buscaCarrosDisponiveis("DISPONIVEL");
    }

    @GetMapping("/getAll")
    public List<Carro> getAllCarros(){
        return carroService.getAll();
    }

    @GetMapping
    public Carro getCarro(@RequestParam String chassi){
        return carroService.findByChassi(chassi);
    }


}
