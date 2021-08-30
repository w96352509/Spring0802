package com.study.spring.case06.jdbc;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import sun.security.mscapi.CKeyPairGenerator.RSA;

public class SelectEmp {
	public static void main(String[] args) {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
       JdbcTemplate jdbcTemplate =ctx.getBean("jdbcTemplate",JdbcTemplate.class);
       //多筆資料
       String sql="select eid , ename , age , createtime from emp";
       List<Map<String, Object>> emps =jdbcTemplate.queryForList(sql);
       for(Map<String, Object>emp:emps) {
    	   System.out.println(emp.get("ename"));
       }
     //單筆(欄)資料
     //現在emp資料表中有幾筆資料
       sql="select count(*) from emp";
       Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
       System.out.println("資料數量"+count);
	
    // 多筆查詢-Entity
    		sql = "select eid, ename, age, createtime from emp";
    		List<Emp> listEmps = jdbcTemplate.query(sql, (ResultSet rs, int rowNum)->{
    			Emp emp = new Emp();
    			Integer eid = rs.getInt("eid");
    			String ename = rs.getString("ename");
    			Integer age = rs.getInt("age");
    			Date createtime = rs.getDate("createtime");
    			emp.setEid(eid);
    			emp.setEname(ename);
    			emp.setAge(age);
    			emp.setCreatetime(createtime);
    			return emp;
    		});
    		System.out.println(listEmps);
    		
    		//多筆查詢-BeanPropertyRowMapper
    		//類似於 BeanUtils
    		//名稱相同自動對應
    		sql = "select eid, ename, age, createtime from emp";
    		List<Emp> listEmps2=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Emp.class));
    		System.out.println(listEmps2);
	}
	
	
}
