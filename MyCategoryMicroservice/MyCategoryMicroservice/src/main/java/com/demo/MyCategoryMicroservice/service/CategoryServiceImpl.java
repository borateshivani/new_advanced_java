package com.demo.MyCategoryMicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.MyCategoryMicroservice.beans.Category;
import com.demo.MyCategoryMicroservice.dao.CategoryDao;




@Service
public class CategoryServiceImpl implements CategoryService{
 
	@Autowired
	CategoryDao cdao;

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}

	@Override
	public Category getByCid(int cid) {
		
		Optional<Category> op=cdao.findById(cid);
		if(op.isPresent())
			return op.get();
		return null;
	}

	
}
