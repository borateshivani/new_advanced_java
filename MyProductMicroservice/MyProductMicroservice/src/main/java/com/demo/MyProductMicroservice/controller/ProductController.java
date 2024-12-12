package com.demo.MyProductMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.MyProductMicroservice.beans.Product;
import com.demo.MyProductMicroservice.dto.ProductDto;
import com.demo.MyProductMicroservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> plist=pservice.getAllProducts();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<ProductDto> getById(@PathVariable int pid){
		ProductDto p=pservice.getById(pid);
		if(p!=null)
			return ResponseEntity.ok(p);
		else
			return ResponseEntity.status(500).body(null);
	}
	@GetMapping("/category/products/{cid}")
	public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable int cid){
		List<ProductDto> plist=pservice.findByCategory(cid);
		
		return ResponseEntity.ok(plist);
		
	}
	
	
	//@GetMapping("/products/{lpr}/{hpr})
	

}
