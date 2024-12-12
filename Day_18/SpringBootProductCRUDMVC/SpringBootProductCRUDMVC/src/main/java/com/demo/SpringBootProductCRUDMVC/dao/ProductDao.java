package com.demo.SpringBootProductCRUDMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SpringBootProductCRUDMVC.beans.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{

}
