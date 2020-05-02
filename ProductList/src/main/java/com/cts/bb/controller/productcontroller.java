package com.cts.bb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bb.model.Product;
import com.cts.bb.service.productserviceimpl;



@RestController
@RequestMapping("/product")
public class productcontroller {
	@Autowired
	private productserviceimpl service;

	@GetMapping("/get")
	public List<Product> fetchProductList()
	{
		List<Product> products=new ArrayList<Product>();
	
		products=service.fetchProductList();
	
		return products;
		
//		return new responsea<Product>(service.fetchProductList(),HttpStatus.OK);
		
	}
	
	@PostMapping("/post")
	public Product saveProduct(@RequestBody Product product)
	{
		return service.saveProductToDB(product);
		  
		
	}
	
	@GetMapping("/id/{id}")
	public Product fetchProductById(@PathVariable int id)
	{
		return service.fetchProductById(id).get();
		
	}
//Delete Mapping
	@GetMapping("/delete/{id}")
	public String DeleteProductById(@PathVariable int id)
	{
		return service.deleteProductById(id);
		
	}
	
	
	@PutMapping("/update/{id}")
	public String updateProduct(@PathVariable int id,@RequestBody Product product)
	{
	
		return service.updateProduct(id,product);
		
	}
		
		
	
//	@DeleteMapping("/ddeleteproductbyid/{id}")
//	public ResponseEntity<Object> ddeleteProductByid(@PathVariable("id")Integer id)
//		{
//			return new ResponseEntity<>(service.ddeleteProductById(id),HttpStatus.OK);
//		}
	

 	
}
