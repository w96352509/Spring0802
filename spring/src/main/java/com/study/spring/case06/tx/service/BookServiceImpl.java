package com.study.spring.case06.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.case06.tx.dao.BookDao;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	 private BookDao bookDao;
	
	@Transactional                 //將方法綁在一起 , 視為一個交易
	@Override
	public void buyOne(Integer wid, Integer bid) {
		int price = bookDao.getPrice(bid); //得到價格
		bookDao.updateStock(bid);//更新庫存
		//製造一個商業邏輯的處理錯誤
		//System.out.println(10/0);
		
		bookDao.updateWallet(wid, price);//錢包減去金額
	}

	@Override
	public void buyMany(Integer wid, Integer... bid) {
		
		
	}
 
}
