package com.study.spring.case06.tx.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.case06.tx.dao.BookDao;
import com.study.spring.case06.tx.eception.InsufficientAmount;
import com.study.spring.case06.tx.eception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	 private BookDao bookDao;
	
	@Transactional(
			rollbackFor = {InsufficientQuantity.class,InsufficientAmount.class},//發生rollback
			//noRollbackFor = { }
			)                 //將方法綁在一起 , 視為一個交易
	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientAmount , InsufficientQuantity{
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		int price = bookDao.getPrice(bid); //得到價格
		bookDao.updateStock(bid);//更新庫存
		//製造一個商業邏輯的處理錯誤
		//System.out.println(10/0);
		
		
		bookDao.updateWallet(wid, price);//錢包減去金額
	}
	@Transactional (
			timeout = 3
			)
	@Override
	public void buyMany(Integer wid, Integer... bids) throws InsufficientAmount , InsufficientQuantity {
		for(int bid : bids) {
			buyOne(wid, bid);
		}
		
	}
 
}
