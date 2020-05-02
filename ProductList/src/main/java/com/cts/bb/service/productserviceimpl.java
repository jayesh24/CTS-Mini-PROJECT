package com.cts.bb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bb.exception.ProductNotFoundException;
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
	
	
	@Override
	public String updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		if(repo.findById(id).isPresent()) {
			
			Product availProduct = repo.findById(id).get();
			availProduct.setPid(product.getPid());
			availProduct.setDesc(product.getDesc());
			availProduct.setName(product.getName());
			availProduct.setPrice(product.getPrice());
			
			if(product.getPid()!=id) {
				throw new ProductNotFoundException("id can't be updated, Please Change to :"+id);

			}
			
			Product updateProduct = repo.save(availProduct);
			return "Product with id "+id+" is updated";
		}
		
		else {
			throw new ProductNotFoundException("Product ID : "+id+" Not Found");
			
		}
	}
	
//	@Override
//	public String ddeleteProductById(int id) {
//		// TODO Auto-generated method stub
//		if(repo.findById(id).isPresent()) {
//			repo.deleteById(id);
//			
//			return "Employee id with "+id+" is deleted";
//		}
//		
//		else {
//			return "Employee id with "+id+" does not exist";
//		}
//		
//	}
}
