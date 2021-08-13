package com.study.spring.case03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.case03.dao.UserDao;
import com.study.spring.case03.dao.UserDaoImpl;

@Service
public class UserServiceImpl implements UserService {
	
	//private UserDao  userDao = new UserDaoImpl();
	
	//自動裝配的順序 byType 在進行 byName
	
	@Autowired
	private UserDao  userDao;
	
	public UserServiceImpl() {
		System.out.println("UserService()");
	}

	@Override
	public void addUser() {
		userDao.createUser();
	}
}
