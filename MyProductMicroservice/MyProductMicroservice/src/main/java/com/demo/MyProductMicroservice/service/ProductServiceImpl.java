package com.demo.MyProductMicroservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.MyProductMicroservice.beans.Product;
import com.demo.MyProductMicroservice.dao.ProductDao;
import com.demo.MyProductMicroservice.dto.ProductDto;
import com.demo.MyProductMicroservice.mapper.ProductDTOMapper;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductDao pdao;

@Override
public List<ProductDto> getAllProducts() {
	List<Product> plst=pdao.findAll();
	plst.forEach(System.out::println);
	List<ProductDto> plist=plst.stream()
	.map(prod->ProductDTOMapper.mapToProductDto(prod))
	.collect(Collectors.toList());
	return plist;
}



@Override
public ProductDto getById(int pid) {
	
	Optional<Product> op=pdao.findById(pid);
	if(op.isPresent()) {
		return ProductDTOMapper.mapToProductDto(op.get());
	}else {
		return null;
	}
	
}




@Override
public List<ProductDto> findByCategory(int cid) {
	List<Product> plst =pdao.getProductsByCid(cid);
	List<ProductDto> plist=plst.stream()
			.map(prod->ProductDTOMapper.mapToProductDto(prod))
			.collect(Collectors.toList());
			return plist;
}
}
