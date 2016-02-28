package com.example.code.service;

import java.util.List;

import com.example.code.model.Product;

public interface ProductService {

	Product findProductById(int id);
	List<Product> getProductList();
	boolean updateProduct(Product product);
	boolean deleteProduct(int id);
	boolean addProduct(Product product);
	
}
