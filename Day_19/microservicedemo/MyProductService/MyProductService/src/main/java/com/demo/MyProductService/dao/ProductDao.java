package com.demo.MyProductService.dao;

import com.demo.MyProductService.beans.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();

    Product findById(int pid);

    boolean save(Product p);

    boolean deleteById(int pid);

    boolean updateById(Product p);

    List<Product> findByCategoryId(int cid);
}
