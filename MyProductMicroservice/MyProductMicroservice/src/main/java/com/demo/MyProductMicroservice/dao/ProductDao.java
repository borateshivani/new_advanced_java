package com.demo.MyProductMicroservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.demo.MyProductMicroservice.beans.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

	@Query(value="select * from product where cid=:cid",nativeQuery=true)
	List<Product> getProductsByCid(int cid);
	
	/*
	 * @Query(value="select * from product  where price between :lpr and :hpr"
	 * ,nativeQuery = true)
	 * //@Query(value="select p from Product p where price between :lpr and :hpr")
	 * List<Product> getByPrice(int lpr, int hpr);
	 */
	
	/*@Procedure(procedureName="getNumproducts")
	public int getCount();*/

}
