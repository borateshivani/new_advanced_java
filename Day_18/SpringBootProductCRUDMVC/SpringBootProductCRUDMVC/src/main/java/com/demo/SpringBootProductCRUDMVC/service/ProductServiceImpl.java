package com.demo.SpringBootProductCRUDMVC.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootProductCRUDMVC.beans.Product;
import com.demo.SpringBootProductCRUDMVC.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductDao pdao;

@Override
public List<Product> getAllProducts() {
	return pdao.findAll();
}

@Override
public boolean addNewProduct(Product p) {
	Product p1= pdao.save(p);
	return p1!=null;
}

@Override
public Product getById(int pid) {
	
	Optional<Product> op=pdao.findById(pid);
	if(op.isPresent()) {
		return op.get();
	}else {
		return null;
	}
	
}

@Override
public boolean updateProduct(Product p) {
	Optional<Product> op=pdao.findById(p.getPid());
	if(op.isPresent()) {
		Product p2=op.get();
		p2.setPname(p.getPname());
		p2.setQty(p.getQty());
		p2.setPrice(p.getPrice());
		pdao.save(p2);
		return true;
	}
	return false;
}

@Override
public boolean deleteById(int pid) {
	Optional<Product> op=pdao.findById(pid);
	if(op.isPresent()) {
	   pdao.delete(op.get());
	   return true;
	}
	return false;
}
}
