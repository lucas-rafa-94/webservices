package com.fiap.webservices;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fiap.webservices.client.ViagemClient;

public class BusinessTest {

	public ViagemClient viagemService;

	@Before
	public void startService() {

		viagemService = new ViagemClient();

	}

	@Test
	public void calculaValorTest() {
		//comentario devops 
		double valor = viagemService.retornaCalc(1000d);

		Assert.assertTrue(valor == 7.5d);
	}

}
