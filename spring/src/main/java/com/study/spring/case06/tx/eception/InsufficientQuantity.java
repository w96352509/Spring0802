package com.study.spring.case06.tx.eception;

//餘額不足的例外
public class InsufficientQuantity extends Throwable {
  public InsufficientQuantity() {
	  super("stock 數量不足");
	  
  }
}
