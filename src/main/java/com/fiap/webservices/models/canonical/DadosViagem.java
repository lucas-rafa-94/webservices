package com.fiap.webservices.models.canonical;

public class DadosViagem {
	
	private Double distancia;
	
	private Double tempoEmSegundos;
	
	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Double getTempoEmSegundos() {
		return tempoEmSegundos;
	}

	public void setTempoEmSegundos(Double tempoEmSegundos) {
		this.tempoEmSegundos = tempoEmSegundos;
	}

	public Double getPrecoTotal(Double taxa, Double precoPorMetro) {
		return (distancia * precoPorMetro) + taxa;
	}

	@Override
	public String toString() {
		return "DadosViagem [distancia=" + distancia + ", tempoEmSegundos=" + tempoEmSegundos + "]";
	}
}
