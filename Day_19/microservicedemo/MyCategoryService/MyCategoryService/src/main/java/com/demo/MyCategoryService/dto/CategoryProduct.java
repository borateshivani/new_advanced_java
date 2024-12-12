package com.demo.MyCategoryService.dto;

import com.demo.MyCategoryService.beans.Category;
import com.demo.MyCategoryService.beans.Product;

import java.util.List;

public class CategoryProduct {
    private Category c;
    private List<Product> plist;

    public CategoryProduct() {
    }

    public CategoryProduct(Category c, List<Product> plist) {
        this.c = c;
        this.plist = plist;
    }

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public List<Product> getPlist() {
        return plist;
    }

    public void setPlist(List<Product> plist) {
        this.plist = plist;
    }

    @Override
    public String toString() {
        return "CategoryProduct{" +
                "c=" + c +
                ", plist=" + plist +
                '}';
    }
}
