package com.study.spring.case06.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateEmp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

		int id = 1;
		String sql = "Update emp set ename=? , age=? where eid=?";
		int rowcount=jdbcTemplate.update(sql, "john2", 27, id); //針對?號順序
		System.out.println("更新成功"+rowcount);

	}

}
