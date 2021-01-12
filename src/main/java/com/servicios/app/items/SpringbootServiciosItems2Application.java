package com.servicios.app.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringbootServiciosItems2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiciosItems2Application.class, args);
	}

}
