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

	@Override
	public int updateEmployee(Employee employee) {
		String sql = "UPDATE public.\"Employee\"SET firstname=?, lastname=? WHERE id = ?";
		int records = jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());
		return records;
	}

	@Override
	public int deleteEmployee(int id) {
		String sql = "DELETE FROM public.\"Employee\" WHERE id = ?";
		int records = jdbcTemplate.update(sql, id);
		return records;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
