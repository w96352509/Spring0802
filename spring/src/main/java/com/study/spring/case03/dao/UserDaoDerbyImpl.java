package com.study.spring.case03.dao;

public class UserDaoDerbyImpl implements UserDao {
	public UserDaoDerbyImpl() {
		System.out.println("UserDaoDerbyImpl()");
	}

	@Override
	public void createUser() {
		System.out.println("Create User ok from derby");
		
	}
}
