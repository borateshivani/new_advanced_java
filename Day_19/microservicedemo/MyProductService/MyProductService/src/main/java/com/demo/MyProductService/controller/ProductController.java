package com.demo.MyProductService.controller;

import com.demo.MyProductService.beans.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.MyProductService.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> plist=productService.getAll();
        return ResponseEntity.ok(plist);
    }

    @GetMapping("/product/{cid}")
    public ResponseEntity<List<Product>>  getProductsbyCategory(@PathVariable int cid){
        List<Product> plist=productService.getByCategoryId(cid);
        return ResponseEntity.ok(plist);
    }
}
