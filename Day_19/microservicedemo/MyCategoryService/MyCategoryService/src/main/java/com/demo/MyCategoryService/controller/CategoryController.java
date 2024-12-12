package com.demo.MyCategoryService.controller;

import com.demo.MyCategoryService.beans.Category;
import com.demo.MyCategoryService.beans.Product;
import com.demo.MyCategoryService.dto.CategoryProduct;
import com.demo.MyCategoryService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RestClient restClient;


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> clist=categoryService.getAll();
        return ResponseEntity.ok(clist);
    }

    @GetMapping("/products/{cid}")
    public ResponseEntity<CategoryProduct> getAllProductsByCategory(@PathVariable int cid){
        //assume the category id exists, otherwise use exceptionhandler
        Category c=null;
        Optional<Category> ob=categoryService.getById(cid);
        if(ob.isPresent()){
            c=ob.get();
        }else{
            //add code to throw exception
        }
      /*  List<Product> plist=restTemplate.getForObject("http://localhost:9494/products/product/{cid}",List.class,cid);
        */

        //to retrive list of product using restClient
        List<Product> plist=restClient.get()
                .uri("http://localhost:9494/products/product/{cid}",cid)
                .retrieve()
                .body(List.class);
        System.out.println(plist);
//        List<Product> plist=restClient.get()
//                .uri("http://MYPRODUCTSERVICE/products/product/{cid}",cid)
//                .retrieve()
//                .body(List.class);
//        System.out.println(plist);

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
