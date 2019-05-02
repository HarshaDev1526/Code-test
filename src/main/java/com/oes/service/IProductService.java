package com.oes.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.oes.model.Product;

@Component
public interface IProductService {
	
	public List<Product> getAllProducts();
	public Product getProductById(String id);

}
