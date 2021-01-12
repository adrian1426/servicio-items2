package com.servicios.app.items.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.app.items.models.Item;
import com.servicios.app.items.models.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("itemServiceFeign")
	private ItemService itemService;
	
	@GetMapping("/items")
	public List<Item> getItems(){
		return itemService.findAll();
	}
	
	@GetMapping("/items/{id}/cantidad/{cantidad}")
	public Item getItemById(@PathVariable Long id,@PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}

}
