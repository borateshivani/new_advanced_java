package com.demo.MyCategoryMicroservice.service;

import java.util.List;

import com.demo.MyCategoryMicroservice.beans.Category;



public interface CategoryService {

	List<Category> getAllCategory();

	Category getByCid(int cid);

	

}
