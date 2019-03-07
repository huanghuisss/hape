package cn.accp.pigcar.util;


import cn.accp.pigcar.pojo.Renttable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyUtil {
	
	public static final String RF ="\r\n";


	public static String getCurrentDate(){
		Date date1 = new Date();
		String date2 = formatDate(date1);
		return date2;
	}

	public static String formatDate(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String cd = df.format(date);
		
		return cd;
	}

	public static Long getRandomId(){
		Long random = (long) (Math.random()*1000000000000000000L);
		return random;
	}

	public static String getSires(List<Renttable> list){
		StringBuilder sb = new StringBuilder();

		sb.append(" [{");
		sb.append("minPointSize: 10,"+RF);
		sb.append("innerSize: '20%',"+RF);
		sb.append("zMin: 0,"+RF);
		sb.append("name: 'countries',"+RF);
		sb.append("data: [");
		
		for (Renttable renttable : list) {
			sb.append("{name: '");
			String carNum = renttable.getCars().getCarNumber();
			sb.append(carNum);
			sb.append("', y: ");
			sb.append(renttable.getCarrentcount());
			sb.append(", z: ");
			sb.append(renttable.getCountPrice());
			sb.append("},");
			
		}
		sb.append("]");
		String sire = sb.toString();
		String s = sire.substring(0, sire.lastIndexOf(","));
		StringBuilder sb1 = new StringBuilder();
		sb1.append(s);
		sb1.append("]");
		sb1.append("}]");
		return sb1.toString();	           
	}
	
	
	public static void main(String[] args) {
		
	}
}
