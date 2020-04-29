package com.cts.bb;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.bb.model.Product;
import com.cts.bb.repository.productrepo;
import com.cts.bb.service.productserviceimpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductListApplicationTests {

	@Autowired
	private productserviceimpl service;
	
	@MockBean
	private productrepo repo;
	
	//Working
	@Test
	public void fetchProductListTest()
	{
		when(repo.findAll()).thenReturn(Stream.of(new Product(100,"USBcable","For Charging",1000),new Product(200,"Adapter","For Cable",2000)).collect(Collectors.toList()));
	
		assertEquals(2, service.fetchProductList().size());
	}
	
	//Working
	@Test
	public void saveProductToDBTest() throws Exception
	{
		Product product=new Product(1,"Card","Payments",100000);
        when(repo.save(product)).thenReturn(product);
		
	}

	//Working
	@Test
	public void fetchProductByIdTest() 
	{   
		Product product=new Product(1,"Dice","Game",10);
        when(repo.findById(product.getPid())).thenReturn(Optional.of(product)).getMock();
	}
	
	//Working
	@Test
	public void deleteProductByIdTest()
	{
		Product product=new Product(9,"Smart Watch","FitBand",2300);
		service.deleteProductById(product.getPid());
		verify(repo,times(1)).deleteById(9);
	}
	
	
}
