package com.study.spring.case06.tx.eception;

//餘額不足的例外
public class InsufficientAmount extends Throwable {
  public InsufficientAmount() {
	  super("Wallet餘額不足");
	  
  }
}
