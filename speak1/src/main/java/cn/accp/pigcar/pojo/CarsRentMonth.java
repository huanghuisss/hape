package cn.accp.pigcar.pojo;

import java.util.Map;


public class CarsRentMonth {

	private Map<String, String> map;
	private String carName;
	
	public CarsRentMonth(){
		
	}
	
	

	public CarsRentMonth(Map<String, String> map, String carName) {
		super();
		this.map = map;
		this.carName = carName;
	}
	
	
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}


	@Override
	public String toString() {
		return "CarsRentMonth [map=" + map + ", carName=" + carName + "]";
	}
	
	
	
}
