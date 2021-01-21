package com.servicios.app.items.models.service;

import java.util.List;

import com.servicios.app.commons.models.entity.Producto;
import com.servicios.app.items.models.Item;

public interface ItemService {
	
	public List<Item> findAll();
	public Item findById(Long id,Integer cantidad);
	public Producto addProduct(Producto producto);
	public Producto editProduct(Producto producto,Long id);
	public void deleteProduct(Long id);

}
