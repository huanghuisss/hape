package cn.accp.pigcar.pojo;


import java.util.HashSet;
import java.util.Set;


public class Cars implements java.io.Serializable {


	private String carNumber;
	private String carType;
	private String color;
	private Double price;
	private int rownum;
	private Double rentPrice;
	private Double deposit;
	private String isRenting;

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	private String carDesc;

	private String carImg;
	private Set rentTables = new HashSet(0);//租金表
	
	
	public Cars(){
		
	}
	
	
	public Cars(String carNumber, String carType, String color, Double price,
			Double rentPrice, Double deposit, String isRenting) {
		super();
		this.carNumber = carNumber;
		this.carType = carType;
		this.color = color;
		this.price = price;
		this.rentPrice = rentPrice;
		this.deposit = deposit;
		this.isRenting = isRenting;
	}
	
	
	

	public Cars(String carNumber, String carType, String color, Double price,
			Double rentPrice, Double deposit, String isRenting, String carDesc,
			String carImg, Set rentTables) {
		super();
		this.carNumber = carNumber;
		this.carType = carType;
		this.color = color;
		this.price = price;
		this.rentPrice = rentPrice;
		this.deposit = deposit;
		this.isRenting = isRenting;
		this.carDesc = carDesc;
		this.carImg = carImg;
		this.rentTables = rentTables;
	}
	
	
	
	
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public String getIsRenting() {
		return isRenting;
	}
	public void setIsRenting(String isRenting) {
		this.isRenting = isRenting;
	}
	public String getCarDesc() {
		return carDesc;
	}
	public void setCarDesc(String carDesc) {
		this.carDesc = carDesc;
	}
	public String getCarImg() {
		return carImg;
	}
	public void setCarImg(String carImg) {
		this.carImg = carImg;
	}
	public Set getRentTables() {
		return rentTables;
	}
	public void setRentTables(Set rentTables) {
		this.rentTables = rentTables;
	}

	@Override
	public String toString() {
		return "Cars [carNumber=" + carNumber + ", carType=" + carType
				+ ", color=" + color + ", price=" + price + ", rentPrice="
				+ rentPrice + ", deposit=" + deposit + ", isRenting="
				+ isRenting + ", carDesc=" + carDesc + ", carImg=" + carImg
				+ ", rentTables=" + rentTables + "]";
	}

}