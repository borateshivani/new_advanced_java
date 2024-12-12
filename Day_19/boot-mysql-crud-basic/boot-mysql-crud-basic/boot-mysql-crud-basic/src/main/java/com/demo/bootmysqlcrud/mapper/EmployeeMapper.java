package com.demo.bootmysqlcrud.mapper;

import com.demo.bootmysqlcrud.dto.EmployeeDto;
import com.demo.bootmysqlcrud.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getName(), employee.getDepartment());
	}

	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(employeeDto.getId(), employeeDto.getName(), employeeDto.getDepartment());
	}

}