  package com.study.spring.case06.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.study.spring.case06.tx.controller.BookController;

public class BuyBook {
	public static void main(String[] args) {
        //[{wid=1, money=100}]
		//[{sid=1, bid=1, amount=3}] 庫存1號 有bid的書 庫存有3本
		
		//(wallet)錢包1 購買 (book)書本1 80元
		//執行 BookController(1,1);
		
		//購買後
		//{wid=1, money=20}  100-80
		//[{sid=1, bid=1, amount=2}] 3-1
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		
		BookController bookController = (BookController)ctx.getBean("bookControllerImpl");
		int wid=1;
		int bid=1;
		bookController.buyBook(wid, bid);
		
	}
}
