package com.demo.MyCategoryMicroservice.dto;




import java.util.List;

import com.demo.MyCategoryMicroservice.beans.Category;

public class CategoryProduct {
    private Category c;
    private List<ProductDto> plist;

    public CategoryProduct() {
    }

    public CategoryProduct(Category c, List<ProductDto> plist) {
        this.c = c;
        this.plist = plist;
    }

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public List<ProductDto> getPlist() {
        return plist;
    }

    public void setPlist(List<ProductDto> plist) {
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
