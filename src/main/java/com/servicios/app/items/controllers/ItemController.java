package com.servicios.app.items.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.servicios.app.items.models.Item;
import com.servicios.app.commons.models.entity.Producto;
import com.servicios.app.items.models.service.ItemService;

@RefreshScope //refresca la información de env y @values sin reiniciar el servicio
@RestController
public class ItemController {
	
	private static Logger  log=LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	@Qualifier("itemServiceFeign")
	private ItemService itemService;
	
	@Value("${configuracion.texto}")
	private String texto;
	
	@GetMapping("/items")
	public List<Item> getItems(){
		return itemService.findAll();
	}
	
	//@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/items/{id}/cantidad/{cantidad}")
	public Item getItemById(@PathVariable Long id,@PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	@PostMapping("/items")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto addProducto(@RequestBody Producto producto) {
		return itemService.addProduct(producto);
	}
	
	@PutMapping("/items/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editProduct(@RequestBody Producto producto,@PathVariable Long id) {
		return itemService.editProduct(producto, id);
	}
	
	@DeleteMapping("/items/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Long id) {
		itemService.deleteProduct(id);
	}
	
	public Item metodoAlternativo(Long id, Integer cantidad) {
		Item item = new Item();
		Producto producto = new Producto();
		
		item.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre("Default");
		producto.setPrecio(123.00);
		item.setProducto(producto);
		
		return item;
	}
	
	@GetMapping("/items/config")
	public ResponseEntity<?> obtnerConfiguracion(@Value("${server.port}") String puerto){
		log.info(texto);
		
		Map<String,String> json= new HashMap<>();
		json.put("texto", texto);
		json.put("puerto", puerto);
		
		if(env.getActiveProfiles().length>0 && env.getActiveProfiles()[0].equals("dev")) {
			json.put("nombre", env.getProperty("configuracion.autor.name"));
			json.put("email", env.getProperty("configuracion.autor.email"));
		}
		
		return new ResponseEntity<Map<String,String>>(json,HttpStatus.OK);
	}

}
