package com.fiap.webservices.controller;

import com.fiap.webservices.models.canonical.Carro;
import com.fiap.webservices.models.business.ResponseCall;
import com.fiap.webservices.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.fiap.webservices.models.canonical.Status.DISPONIVEL;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    CarroService carroService;

    @PostMapping
    public ResponseCall insert(@RequestBody Carro carro){
        return carroService.criaCarro(carro);
    }

    @GetMapping("/")
    public List<Carro> getCarros(@RequestParam(value = "chassi", required = false) String chassi,
                                 @RequestParam(value = "disponivel", required = false) String disponivel){

        List<Carro> carros = new ArrayList<>();

        if(chassi != null && !chassi.isEmpty()){
            Carro carro = carroService.findByChassi(chassi);
            if(carro != null) {
                carros.add(carro);
            }
        } else {
            carros.addAll(carroService.getAll());
        }

        if(disponivel != null && !disponivel.isEmpty()){
            carros = carros.stream().filter(carro -> carro.getStatus().equals(DISPONIVEL.name())).collect(Collectors.toList());
        }

        return carros;
    }

}
