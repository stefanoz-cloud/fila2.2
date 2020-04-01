package com.fila2.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fila2.services.interfaces.RegioniService;
//prova di restTemplate che non uso, se vuoi guardala su postMan
@RestController
@RequestMapping(value = "/template")
public class RestTemplateNazioniController {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	RegioniService regioniService;

	@RequestMapping(value = "/nazioni", produces = "application/json")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("https://restcountries.eu/rest/v2/all", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	
	
}
