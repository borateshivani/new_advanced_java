package com.demo.SpringBootProductCRUDMVC.service;

import java.util.List;

import com.demo.SpringBootProductCRUDMVC.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	boolean addNewProduct(Product p);

	Product getById(int pid);

	boolean updateProduct(Product p);

	boolean deleteById(int pid);

}
