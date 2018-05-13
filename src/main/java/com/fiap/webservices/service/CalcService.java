package com.fiap.webservices.service;

import org.springframework.web.client.RestTemplate;

public class CalcService {

    RestTemplate restTemplate = new RestTemplate();

    public double calcService(){

        String res = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?address=Pouso%20Alegre%20franco%20da%20rocha&key=AIzaSyCGBhnp8Nlhz0J47MYTXvkZweqbExjzGVM",
                String.class);

        System.out.print(res);

        return 0.0;
    }
}
