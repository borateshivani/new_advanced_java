package com.demo.MyCategoryMicroservice.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.client.RestClient;

import com.demo.MyCategoryMicroservice.beans.Category;
import com.demo.MyCategoryMicroservice.beans.Product;
import com.demo.MyCategoryMicroservice.dto.CategoryProduct;
import com.demo.MyCategoryMicroservice.dto.ProductDto;
import com.demo.MyCategoryMicroservice.service.CategoryService;



@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	RestClient restClient;
	@Autowired
	CategoryService cservice;
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories(){
		
		List<Category> clist = cservice.getAllCategory();
		return ResponseEntity.ok(clist);
	}

	@GetMapping("/categories/{cid}")
	public ResponseEntity<Category> getByCid(@PathVariable int cid){
		
		Category c = cservice.getByCid(cid);
		return ResponseEntity.ok(c);
	} 
	
	@GetMapping("/category/products/{cid}")
	public ResponseEntity<CategoryProduct> getBycategoryProduct(@PathVariable int cid){
		
		Category c = cservice.getByCid(cid);
		//to retrive list of product using restClient
//        List<ProductDto> plist=restClient.get()        		                           
//                .uri("http://localhost:8383/product/category/products/{cid}",cid)
//                .retrieve()
//                .body(List.class);
//        System.out.println(plist);
        List<ProductDto> plist=restClient.get()
                .uri("http://MYPRODUCTMICROSERVICE/product/category/products/{cid}",cid)
                .retrieve()
                .body(List.class);
        System.out.println(plist);
        
        return ResponseEntity.ok(new CategoryProduct(c,plist));

        //code if method returns string
//        String response = restTemplate.exchange("http://localhost:9494/products/product/{cid}",
//                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, cid)
//                .getBody();
//        String response = restTemplate.exchange("http://MYPRODUCTSERVICE/products/product/{cid}",
//                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, cid).getBody();

//        List<Product> response=restClient.get()
//                .uri("http://localhost:9494/products/product/{cid}",cid)
//                .retrieve()
//                .toEntity(new ParameterizedTypeReference<List<Product>>() {}).getBody();

        /*System.out.println("Response Received as " + response);*/
        //return "CategoryId -  " + cid + " Product Details " + response;

    
		
	}
	
}
