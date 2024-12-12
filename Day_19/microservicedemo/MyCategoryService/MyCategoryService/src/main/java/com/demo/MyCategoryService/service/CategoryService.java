package com.demo.MyCategoryService.service;

import com.demo.MyCategoryService.beans.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Optional<Category> getById(int cid);

    boolean addCategory(Category c);

    boolean modifyCategory(Category c);

    boolean removeById(int cid);
}
