package cn.accp.pigcar.pojo;

import java.io.Serializable;

public class CountBean implements Serializable{
	private Cars car;
	public Cars getCar() {
		return car;
	}
	public void setCar(Cars car) {
		this.car = car;
	}
	//每辆汽车的销售总量
	private Long countPrice;
	//每辆汽车的编号
	private Long carid;
	//每辆车被租的次数
	private Long carrentcount;
	public Long getCountPrice() {
		return countPrice;
	}
	public Long getCarrentcount() {
		return carrentcount;
	}
	public void setCarrentcount(Long carrentcount) {
		this.carrentcount = carrentcount;
	}
	public void setCountPrice(Long countPrice) {
		this.countPrice = countPrice;
	}
	public Long getCarid() {
		return carid;
	}
	public void setCarid(Long carid) {
		this.carid = carid;
	}
	
}
