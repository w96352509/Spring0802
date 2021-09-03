package com.study.spring.case06.tx.dao;

import com.study.spring.case06.tx.eception.InsufficientAmount;
import com.study.spring.case06.tx.eception.InsufficientQuantity;

public interface BookDao {

	Integer getPrice(Integer bid);

	Integer updateStock(Integer bid)throws InsufficientQuantity;

	Integer updateWallet(Integer wid, Integer money)throws InsufficientAmount;

}
