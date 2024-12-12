package com.demo.bootmysqlcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bootmysqlcrud.entity.DAOUser;

public interface UserRepository extends JpaRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String name);
}
