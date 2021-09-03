package com.study.spring.case06.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer getPrice(Integer bid) {
		String sql = "Select price from book where bid=?";
		Object[] args = new Object[] { bid };
		return jdbcTemplate.queryForObject(sql, args, Integer.class);
	}

	@Override
	public Integer updateStock(Integer bid) {
		// 檢查庫存
		String sql = "select amount from stock where bid=?";
		Object[] args = new Object[] { bid };
		int amount = jdbcTemplate.queryForObject(sql, args, Integer.class);
		if (amount <= 0) {
			throw new RuntimeException("庫存不足"); // 非檢視例外
		}
		// 修改庫存
		sql = "update stock set amount = amount - 1 where bid=?";

		return jdbcTemplate.update(sql, args);
	}

	@Override
	public Integer updateWallet(Integer wid, Integer money) {
		String sql = "update wallet set money = money - ? where wid=?";
		Object[] args = new Object[] { money, wid };
		return jdbcTemplate.update(sql, args);
	}

}
