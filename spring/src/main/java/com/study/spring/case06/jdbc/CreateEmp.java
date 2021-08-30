package com.study.spring.case06.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateEmp {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
	JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

	@Test
	public void test() {
		// case1
		// case2();
		case3();

	}

	// 單筆新增
	public void case1() {
		String sql = "Insert into emp(ename,age) values(?,?)";
		jdbcTemplate.update(sql, "Jo", 21);
		System.out.println("Insert OK");
	}

	// 多筆新增
	public void case2() {
		String sql = "Insert into emp(ename,age) values(?,?)";
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] { "Jean", 22 });
		list.add(new Object[] { "helen", 22 });
		list.add(new Object[] { "jack", 24 });
		int[] rows = jdbcTemplate.batchUpdate(sql, list);
		System.out.println(Arrays.toString(rows));// 每筆被更動

	}

	// 多筆新增2
	public void case3() {
		String sql = "Insert into emp(ename,age) values(?,?)";
		List<Emp> emps = Arrays.asList(
				new Emp("Anita", 25), 
				new Emp("Vic", 25));
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// i=emp的index
				ps.setString(1, emps.get(i).getEname());
				ps.setInt(2, emps.get(i).getAge());

			}

			@Override
			public int getBatchSize() {

				return emps.size();
			}
		};
		int[] rows = jdbcTemplate.batchUpdate(sql, setter);
		System.out.println(Arrays.toString(rows));// 每筆被更動
	}
}
