package com.fiap.webservices.utils;

import com.fiap.webservices.models.business.Localizacao;
import com.fiap.webservices.models.canonical.DadosViagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public  class ViagemUtils {

    private Double TAXA = 4.50d;

    private Double PRECO_POR_METRO = 0.003d;

    public double calculaValor(Localizacao localizacaoUsuario, Localizacao localizacaoCarro) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();

        String s = restTemplate.getForObject("https://maps.googleapis.com/maps/api/directions/json?origin="+localizacaoCarro.getLatitude()+","+localizacaoCarro.getLongitude()+"&destination="+localizacaoUsuario.getLatitude()+","+localizacaoUsuario.getLongitude()+"&key=AIzaSyCGBhnp8Nlhz0J47MYTXvkZweqbExjzGVM", String.class);
        JSONArray js = null;
        JSONObject json = null;
        JSONObject distancia = null;
        JSONObject duracao = null;
        DadosViagem dados = new DadosViagem();

        json = new JSONObject(s);
        js = json.getJSONArray("routes");
        json = (JSONObject) js.get(0);
        js = json.getJSONArray("legs");

        if (js.length() > 0) {

            json = (JSONObject) js.get(0);
            json.getJSONObject("distance");

            distancia = json.getJSONObject("distance");
            duracao = json.getJSONObject("duration");

            dados.setDistancia(distancia.getDouble("value"));
            dados.setTempoEmSegundos(duracao.getDouble("value"));
        }

        return dados.getPrecoTotal(TAXA, PRECO_POR_METRO);
    }
}
