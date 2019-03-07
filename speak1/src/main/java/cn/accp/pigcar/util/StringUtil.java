package cn.accp.pigcar.util;

import cn.accp.pigcar.pojo.CarsRentMonth;

import java.util.List;

public class StringUtil {
	public static String formatString(List<CarsRentMonth> monthAmount){
		StringBuilder sb = new StringBuilder();
		//��ӿ�ͷ
		sb.append("[ ");
		//������������
		for(int i= 0 ; i< monthAmount.size() ;i++){
			CarsRentMonth carsRentMonth = monthAmount.get(i);
			System.out.println("车的名字==="+carsRentMonth.getCarName());
			System.out.println("车的月份map==="+carsRentMonth.getMap());
			sb.append("{ name :'"+carsRentMonth.getCarName()+"',");
			sb.append("data : [");

			for(int j = 1 ; j<= carsRentMonth.getMap().size();j++){
				carsRentMonth.getMap().get(""+j);
				if(j==carsRentMonth.getMap().size()){
					sb.append(carsRentMonth.getMap().get(""+j));
				}else{
					sb.append(carsRentMonth.getMap().get(""+j)+",");
				}
			}
			if(i==(monthAmount.size()-1)){
				sb.append(" ] }");
			}else{
				sb.append(" ] },");
			}
		}
		//��ӽ�β
		sb.append(" ]");
		return sb.toString();
	}
	
}
