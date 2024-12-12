package com.demo.MyCategoryService.service;

import com.demo.MyCategoryService.beans.Category;
import com.demo.MyCategoryService.dao.CategoryDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAll() {
        return categoryDao.findAll();
    }

    @Override
    public Optional<Category> getById(int cid) {
        return categoryDao.findById(cid);
    }

    @Override
    public boolean addCategory(Category c) {
        return categoryDao.save(c);
    }

    @Override
    public boolean modifyCategory(Category c) {
        return categoryDao.updateByID(c);
    }

    @Override
    public boolean removeById(int cid) {
        return categoryDao.deleteById(cid);
    }
}
