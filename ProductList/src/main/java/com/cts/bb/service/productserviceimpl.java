package com.cts.bb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bb.model.Product;
import com.cts.bb.repository.productrepo;

@Service
public class productserviceimpl implements productservice{

	@Autowired
	private productrepo repo;
	
	@Override
	public List<Product> fetchProductList()
	{
		return repo.findAll();
		
	}
	
	@Override
	public Product saveProductToDB(Product product)
	{
		return repo.save(product);
	}
	
	@Override
	public Optional<Product> fetchProductById(int id)
	{	
		return repo.findById(id);
		
	}
	
	@Override
	public String deleteProductById(int id)
	{
		String result;
		try {
			 repo.deleteById(id);
			result="Product Succesfully Deleted";
		} catch (Exception e) {
			result="Product with id is not deleted";
		}
		return result;
		
		
	}
}
