package com.demo.MyProductService.service;

import com.demo.MyProductService.beans.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(int pid);

    boolean inssertProduct(Product p);

    boolean removeProduct(int pid);

    boolean modifyProduct(Product p);

    List<Product> getByCategoryId(int cid);
}
