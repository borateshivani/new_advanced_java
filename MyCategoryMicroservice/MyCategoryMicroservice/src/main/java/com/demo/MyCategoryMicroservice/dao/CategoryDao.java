package com.demo.MyCategoryMicroservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.demo.MyCategoryMicroservice.beans.Category;




public interface CategoryDao extends JpaRepository<Category,Integer>{

	

}
