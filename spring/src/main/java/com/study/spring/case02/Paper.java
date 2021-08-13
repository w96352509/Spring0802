package com.study.spring.case02;

public class Paper {
  private Integer id ;
  private Color color;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Color getColor() {
	return color;
}
public void setColor(Color color) {
	this.color = color;
}
@Override
public String toString() {
	return "Paper [id=" + id + ", color=" + color + "]";
}
  
}
