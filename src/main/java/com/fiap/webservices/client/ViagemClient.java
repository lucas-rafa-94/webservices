package com.fiap.webservices.client;

import com.fiap.webservices.client.response.GoogleResponse;
import com.fiap.webservices.models.business.Localizacao;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public  class ViagemClient {

    private Double TAXA = 4.50d;

    private Double PRECO_POR_METRO = 0.003d;

    @Autowired
    private RestTemplate restTemplate;

    private static final String GOOGLE_URL_API = "https://maps.googleapis.com/maps/api/directions/json?origin=%s,%s&destination=%s,%s&key=AIzaSyCGBhnp8Nlhz0J47MYTXvkZweqbExjzGVM";

    public Double calculaValor(Localizacao localizacaoUsuario, Localizacao localizacaoCarro) {

        GoogleResponse response = restTemplate.getForObject(
                String.format(GOOGLE_URL_API,
                        localizacaoCarro.getLatitude(), localizacaoCarro.getLongitude(),
                        localizacaoUsuario.getLatitude(), localizacaoUsuario.getLongitude()), GoogleResponse.class);

        return retornaCalc(response.getRoutes().getLegs().getDistance().getValue());

    }
    
    
    public Double retornaCalc(Double distancia) {
    	return (distancia * PRECO_POR_METRO) + TAXA;
    }
}
