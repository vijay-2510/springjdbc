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

		employee.setId(1);
		employee.setFirstName("Vikas");
		employee.setLastName("Kumar");
		// int result = employeeDao.createEmployee(employee);
		// int result = employeeDao.updateEmployee(employee);
		int result = employeeDao.deleteEmployee(2);

		System.out.println("inserted successfully " + result + " records");
	}

}
