package com.cts.bb.service;

import java.util.List;
import java.util.Optional;

import com.cts.bb.model.Product;

public interface productservice {

public abstract List<Product> fetchProductList();
public abstract Product saveProductToDB(Product product);
public abstract Optional<Product> fetchProductById(int id);
public abstract String deleteProductById(int id);
//public abstract String ddeleteProductById(int id);
//String updateEmployee(int id, Product product);
public abstract String updateProduct(int id, Product product);
}
