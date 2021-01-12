package com.servicios.app.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.servicios.app.items.models.Producto;

@FeignClient(name = "servicio-productos",url = "localhost:8001")
public interface ProductoClienteRest {
	
	@GetMapping("/productos")
	public List<Producto> getProducts();
	
	@GetMapping("/productos/{id}")
	public Producto getProductById(@PathVariable Long id);

}
