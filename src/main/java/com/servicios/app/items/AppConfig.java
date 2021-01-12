package com.servicios.app.items;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean("clienteRest") //si no le pasamos un nombre , toma el de la función
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}

}
