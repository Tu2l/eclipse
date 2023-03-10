package com.cg.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Product;

//@Controller
//public class ProductController {
//	
//	/*
//	 * http://localhost:8080/ 
//	 */
//	@ResponseBody
//	@RequestMapping(path = "/")
//	public String home() {
//		return "<h1>Welcome to SpringBoot Home</h1>";
//	}
//}

@RestController
public class ProductController {
	private List<Product> productList = new ArrayList<>();

	private void generateProducts() {
		for(int i=1;i<=10;i++) {
			productList.add(new Product(i*834,"Product "+i,(i*23)));
		}
	}

	@RequestMapping(path = "/")
	public String home() {
		return "<h1>Welcome to SpringBoot home!</h1>";
	}

	@RequestMapping(path = "/product/all")
	public List<Product> getAllProducts() {
		if (productList.isEmpty())
			generateProducts();

		return productList;
	}
}