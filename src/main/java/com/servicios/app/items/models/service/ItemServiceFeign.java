package com.servicios.app.items.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.servicios.app.items.clients.ProductoClienteRest;
import com.servicios.app.items.models.Item;

@Service("itemServiceFeign")
@Primary
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		return clienteFeign.getProducts().stream().map(producto-> new Item(producto, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.getProductById(id), cantidad);
	}

}
