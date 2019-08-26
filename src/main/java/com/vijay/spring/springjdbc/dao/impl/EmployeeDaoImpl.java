package com.vijay.spring.springjdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.vijay.spring.springjdbc.dao.EmployeeDao;
import com.vijay.spring.springjdbc.dao.rowmapper.EmployeeRowMapper;
import com.vijay.spring.springjdbc.dto.Employee;

@Component("employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
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

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * FROM public.\"Employee\" WHERE id = ?";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		Employee emp = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * FROM public.\"Employee\"";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper);
		return employees;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
