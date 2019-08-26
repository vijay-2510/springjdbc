package com.vijay.spring.springjdbc.dao;

import com.vijay.spring.springjdbc.dto.Employee;

public interface EmployeeDao {
	int createEmployee(Employee employee);
	int updateEmployee(Employee employee);
}
