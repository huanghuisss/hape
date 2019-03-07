package cn.accp.pigcar.service;

import cn.accp.pigcar.pojo.Renttable;

import java.util.List;

public interface CountRentService {
	/**
	 * 统计每辆汽车的租赁费用
	 */
	List<Renttable> countAllShouldPayPrice();
	/**
	 * 统计每辆车被出租出去的次数
	 */
	List<Renttable> countRentCarCount();

}
