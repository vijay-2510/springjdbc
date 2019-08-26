package com.vijay.spring.springjdbc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateTest {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/vijay/spring/springjdbc/dbconfig.xml");
		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
		String sql = "INSERT INTO public.\"Employee\"(id, firstname, lastname)VALUES (?, ?, ?);";
		// String sql1 = "select * from Employee";
		int records = template.update(sql, 1, "Vijay", "Kumar");
		// template.execute(sql1);
		System.out.println("no. of records inserted: " + records);
		context.close();
	}

}
