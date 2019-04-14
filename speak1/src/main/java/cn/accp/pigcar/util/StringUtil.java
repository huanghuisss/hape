package cn.accp.pigcar.util;

import cn.accp.pigcar.pojo.CarsRentMonth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtil {
	public static List<Map<String,Object>> formatString(List<CarsRentMonth> monthAmount){
		StringBuilder sb = new StringBuilder();

		sb.append("[ ");
		List<Map<String,Object>> h=new ArrayList<>();
		for(int i= 0 ; i< monthAmount.size() ;i++){
			CarsRentMonth carsRentMonth = monthAmount.get(i);
			Map<String,Object> m=new HashMap<>();
			m.put("name",carsRentMonth.getCarName());
			List<Integer> l=new ArrayList<>();
			for(int j = 1 ; j<= carsRentMonth.getMap().size();j++){
				l.add(Integer.parseInt(carsRentMonth.getMap().get(""+j)));
			}
			m.put("data",l);
			h.add(m);
		}
		return h;
	}
	
}
