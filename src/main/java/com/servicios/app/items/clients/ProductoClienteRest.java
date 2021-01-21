package com.servicios.app.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.servicios.app.commons.models.entity.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
	
	@GetMapping("/productos")
	public List<Producto> getProducts();
	
	@GetMapping("/productos/{id}")
	public Producto getProductById(@PathVariable Long id);
	
	@PostMapping("/productos")
	public Producto addProduct(@RequestBody Producto producto);
	
	@PutMapping("/productos/{id}")
	public Producto editProduct(@RequestBody Producto producto,@PathVariable Long id);
	
	@DeleteMapping("/productos/{id}")
	public void deleteProduct(@PathVariable Long id);

}
