package com.demo.bootmysqlcrud.service;

import java.util.List;

import com.demo.bootmysqlcrud.dto.EmployeeDto;
import com.demo.bootmysqlcrud.exception.EmployeeNotFoundException;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long employeeId) throws EmployeeNotFoundException;
	List<EmployeeDto> getEmployees();
	void deleteEmployee(Long employeeId) throws EmployeeNotFoundException;
	EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFoundException;

}