package com.study.spring.case03.dao;

import org.springframework.stereotype.Repository;

//OK
@Repository
public class UserDaoDerbyImpl implements UserDao {
	public UserDaoDerbyImpl() {
		System.out.println("UserDaoDerbyImpl()");
	}

	@Override
	public void createUser() {
		System.out.println("Create User ok from derby");
		
	}
}
