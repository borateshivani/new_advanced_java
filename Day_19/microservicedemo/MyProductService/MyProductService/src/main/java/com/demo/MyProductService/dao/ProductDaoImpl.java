package com.demo.MyProductService.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.demo.MyProductService.beans.Product;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("select * from product",(rs,rowNum)->{
                  Product p=new Product();
                  p.setPid(rs.getInt(1));
                  p.setPname(rs.getString(2));
                  p.setQty(rs.getInt(3));
                  p.setPrice(rs.getDouble(4));
                  LocalDate ldt= rs.getDate(5).toLocalDate();
                  p.setExpdata(ldt);
                  p.setCid(rs.getInt(6));
                  return p;

        });
    }

    @Override
    public Product findById(int pid) {
       return jdbcTemplate.queryForObject("select * from product where pid=?",new Object[]{pid},(rs,rowNum)->{
            Product p=new Product();
            p.setPid(rs.getInt(1));
            p.setPname(rs.getString(2));
            p.setQty(rs.getInt(3));
            p.setPrice(rs.getDouble(4));
            LocalDate ldt= rs.getDate(5).toLocalDate();
            p.setExpdata(ldt);
            p.setCid(rs.getInt(6));
            return p;

        });
    }

    @Override
    public boolean save(Product p) {
        int n=jdbcTemplate.update("insert into product values(?,?,?,?,?,?)",new Object[]{
                p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getExpdata(),p.getCid()
        });
        return n>0;
    }

    @Override
    public boolean deleteById(int pid) {
        int n=jdbcTemplate.update("delete from product where pid=?",new Object[]{
                pid
        });
        return n>0;
    }

    @Override
    public boolean updateById(Product p) {
       int n=jdbcTemplate.update("update product set pname=?,qty=?,price=?,expdate=?,cid=? where pid=?",new Object[]{
                p.getPname(),p.getQty(),p.getPrice(),p.getExpdata(),p.getCid(),p.getPid()
        });
        return n>0;
    }

    @Override
    public List<Product> findByCategoryId(int cid) {
        return jdbcTemplate.query("select * from product where cid=?",new Object[]{cid},(rs,rowNum)->{
            Product p=new Product();
            p.setPid(rs.getInt(1));
            p.setPname(rs.getString(2));
            p.setQty(rs.getInt(3));
            p.setPrice(rs.getDouble(4));
            LocalDate ldt= rs.getDate(5).toLocalDate();
            p.setExpdata(ldt);
            p.setCid(rs.getInt(6));
            return p;

        });
    }
}
