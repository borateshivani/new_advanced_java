package com.demo.MyProductMicroservice.service;

import java.util.List;

import com.demo.MyProductMicroservice.beans.Product;
import com.demo.MyProductMicroservice.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProducts();

	ProductDto getById(int pid);
	
	List<ProductDto> findByCategory(int cid);

}
