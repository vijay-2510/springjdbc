package com.vijay.spring.springjdbc.dao;

import java.util.List;

import com.vijay.spring.springjdbc.dto.Employee;

public interface EmployeeDao {
	int createEmployee(Employee employee);

	int updateEmployee(Employee employee);

	int deleteEmployee(int id);

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();
}
