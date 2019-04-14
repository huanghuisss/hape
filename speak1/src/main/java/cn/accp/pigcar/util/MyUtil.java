package cn.accp.pigcar.util;


import cn.accp.pigcar.pojo.Renttable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

	public static List<Map<String,Object>> getSires(List<Renttable> list){

		Sires s=new Sires();
		List<Map<String,Object>> ss=new ArrayList<>();
		for(Renttable aa : list){
			Map<String,Object> mm=new HashMap<>();
			mm.put("name",aa.getCars().getCarNumber());
			mm.put("y",aa.getCarrentcount());
			mm.put("z",aa.getCountPrice());
			ss.add(mm);
		}
		return ss;
	}
	
	
	public static void main(String[] args) {
		
	}
}
