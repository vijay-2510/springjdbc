package com.vijay.spring.springjdbc.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vijay.spring.springjdbc.dao.EmployeeDao;
import com.vijay.spring.springjdbc.dto.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/vijay/spring/springjdbc/test/dbconfig.xml");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDaoImpl");
		Employee employee = new Employee();

		employee.setId(2);
		employee.setFirstName("Vijay");
		employee.setLastName("Pandey");

		int result = employeeDao.createEmployee(employee);

		System.out.println("inserted successfully " + result + " records");
	}

}
