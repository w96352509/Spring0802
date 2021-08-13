package com.study.spring.case02;

public class Round {
 private Double r ;
 private Double area;
public Double getR() {
	return r;
}
public void setR(Double r) {
	this.r = r;
}
public Double getArea() {
	return area;
}
public void setArea(Double area) {
	this.area = area;
}
@Override
public String toString() {
	return "round [r=" + r + ", area=" + area + "]";
}
 public Double getRoundArea() {
	 area=Math.pow(r, 2)*Math.PI;
	 return area;
 }
}
