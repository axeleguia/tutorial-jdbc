package com.example.code.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.code.model.Product;
import com.example.code.service.ProductService;
import com.example.code.service.impl.ProductServiceImpl;

public class ProductController {

	private static final Logger log = LogManager.getLogger(CustomerController.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		log.info("#ProductController");

		ProductController controller = new ProductController();

		Scanner scanner = new Scanner(System.in);
		int optionSelected = 1;

		System.out.println("TYPE THE NUMBER IN THE CONSOLE TO EXECUTE METHOD: [1] getProductList [2] addProduct [3] updateProduct [4] deleteProduct [5] findProductById");
		optionSelected = scanner.nextInt();
		log.info("Option selected: "+ optionSelected + "\n");

		switch (optionSelected) {
		case 1:
			controller.getProductList();
			break;
		case 2:
			controller.addProduct();
			break;
		case 3:
			controller.updateProduct();
			break;
		case 4:
			controller.deleteProduct();
			break;
		case 5:
			controller.findProductById();
			break;
		}

	}

	public void getProductList() {

		ProductService productService = new ProductServiceImpl();
		List<Product> productList = productService.getProductList();
		for (Product product : productList) {
			System.out.println(product);
		}
	}

	@SuppressWarnings("unused")
	public void findProductById() {

		ProductService productService = new ProductServiceImpl();
		Product product = productService.findProductById(1);

	}

	public void updateProduct() {

		ProductService productService = new ProductServiceImpl();
		Product product = productService.findProductById(1);
		product.setUnitPrice(6.70);
		productService.updateProduct(product);

	}

	public void deleteProduct() {

		ProductService productService = new ProductServiceImpl();
		productService.deleteProduct(2);
	}

	public void addProduct() {

		ProductService productService = new ProductServiceImpl();
		Product product = new Product();
		product.setProductName("Redbull");
		product.setUnitPrice(3.50);
		product.setStock(116);
		productService.addProduct(product);
	}
}
