package cn.accp.pigcar.service;


import cn.accp.pigcar.pojo.CarsRentMonth;
import cn.accp.pigcar.pojo.Renttable;

import java.util.List;

public interface StatisticsService {
	//获取所有，租车信息
	List<Renttable> getAllStati();
	//查询单个
	Renttable getOneStati(int tableid);
	/**
	 * 查询单个
	 */
	Renttable getOneStati(Long tableid);

	//查询按月分布统计车辆租出情况
	List<CarsRentMonth> getMonthAmount();
}
