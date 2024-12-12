package com.demo.MyProductService.service;

import com.demo.MyProductService.beans.Product;
import com.demo.MyProductService.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.MyProductService.service.ProductService;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public Product getById(int pid) {
        return productDao.findById(pid);
    }

    @Override
    public boolean inssertProduct(Product p) {
        return productDao.save(p);
    }

    @Override
    public boolean removeProduct(int pid) {
        return productDao.deleteById(pid);
    }

    @Override
    public boolean modifyProduct(Product p) {
        return productDao.updateById(p);
    }

    @Override
    public List<Product> getByCategoryId(int cid) {
        return productDao.findByCategoryId(cid);
    }
}
