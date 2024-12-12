package com.demo.bootmysqlcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bootmysqlcrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}