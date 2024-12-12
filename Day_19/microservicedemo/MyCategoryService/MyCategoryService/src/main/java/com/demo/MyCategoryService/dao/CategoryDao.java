package com.demo.MyCategoryService.dao;

import com.demo.MyCategoryService.beans.Category;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;
import java.util.Optional;
public interface CategoryDao {


    List<Category> findAll();

    Optional<Category> findById(int cid);

    boolean save(Category c);

    boolean updateByID(Category c);

    boolean deleteById(int cid);
}
