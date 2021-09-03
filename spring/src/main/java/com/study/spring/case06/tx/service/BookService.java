package com.study.spring.case06.tx.service;

public interface BookService {
  void buyOne(Integer wid , Integer bid);
  void buyMany(Integer wid , Integer... bid);
}
