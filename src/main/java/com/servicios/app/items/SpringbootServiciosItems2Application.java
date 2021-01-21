package com.servicios.app.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
//desabilita la configuracion de conexión  BD, ya que por no lo necesitamos
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootServiciosItems2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiciosItems2Application.class, args);
	}

}
