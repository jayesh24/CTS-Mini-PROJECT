package com.cts.bb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bb.model.Product;
import com.cts.bb.service.productserviceimpl;



@RestController
//@RequestMapping("/vapi")
public class productcontroller {
	@Autowired
	private productserviceimpl service;

	@GetMapping("/getproductlist")
	public List<Product> fetchProductList()
	{
		List<Product> products=new ArrayList<Product>();
		//logic for fetch
		products=service.fetchProductList();
		return products;
		
	}
	
	@PostMapping("/addproduct")
	public Product saveProduct(@RequestBody Product product)
	{
		return service.saveProductToDB(product);
		  
		
	}
	
	@GetMapping("/getproductbyid/{id}")
	public Product fetchProductById(@PathVariable int id)
	{
		return service.fetchProductById(id).get();
		
	}
//Delete Mapping
	@GetMapping("/deleteproductbyid/{id}")
	public String DeleteProductById(@PathVariable int id)
	{
		return service.deleteProductById(id);
		
	}

 	
}
