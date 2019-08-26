package com.vijay.spring.springjdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.vijay.spring.springjdbc.dao.EmployeeDao;
import com.vijay.spring.springjdbc.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public int createEmployee(Employee employee) {
		String sql = "INSERT INTO public.\"Employee\"(id, firstname, lastname)VALUES (?, ?, ?);";
		int records = jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
		return records;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
