package cn.accp.pigcar.service.impl;


import cn.accp.pigcar.dao.CarDao;
import cn.accp.pigcar.dao.StatisticsDao;
import cn.accp.pigcar.pojo.Cars;
import cn.accp.pigcar.pojo.CarsRentMonth;
import cn.accp.pigcar.pojo.Renttable;
import cn.accp.pigcar.service.StatisticsService;
import cn.accp.pigcar.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	@Resource
	private StatisticsDao statisticsDao;
	@Resource
	private CarDao carDao;
	/*
	 * 获得所有租车信息
	 */
	@Override
	public List<Renttable> getAllStati() {
		//获得系统当前月份的最后一天
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH,
				ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String lastday = format.format(ca.getTime());
		System.out.println("===============last:" + lastday);
		return statisticsDao.getAllStati(lastday);
	}
	/*
	 * 查询单个业务信息
	 */
//	@Override
//	public Renttable getOneStati(int tableid) {
//		return mapper.getOneStati(tableid);
//	}
	@Override
	public Renttable getOneStati(Long tableid) {
		// TODO Auto-generated method stub
		return statisticsDao.getOneStati(tableid);
	}

	@Override
	public Renttable getOneStati(int tableid) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 查询按月分布统计车辆租出情况
	 */
	@Override
	public List<CarsRentMonth> getMonthAmount() {
		// 存放参数的map
		Map<String, String> paramap = new HashMap<String, String>();
		//获得当年的月份
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		//数据用于对象存放。车名字，月份以及对应的租车次数
		List<CarsRentMonth> crmList = new ArrayList<CarsRentMonth>();
		//map,存放月份，出租次数
		Map<String, String> map2 = null;
		// 首先获得车的信息List
		List<Cars> AllCars = carDao.selectAllCars();
		System.out.println("第一步获取的全部车辆==============" + AllCars);
		// 遍历车辆信息，获取id
		for (Cars cars : AllCars) {
			//实例化内层map
			map2 = new HashMap<String, String>();
			//获取id
			String carid = cars.getCarNumber();
			// 12个月份的迭代,查找每个月的，出租该id的车的数量
			for (int i = 1; i <= 12; i++) {
				// 通过id和月份查找
				Map<String, String> map = DateUtil.getDate(year, i);
				/*System.out.println("本月第一天：" + map.get("first"));
				System.out.println("本月最后一天：" + map.get("last"));*/
				// 将月份放进map
				paramap.put("carid", carid);
				paramap.put("start", map.get("first"));
				paramap.put("end", map.get("last"));
				List<Renttable> amount = statisticsDao.getAmountByCarIdMonth(paramap);
				System.out.println(year+"年"+i+"月份"+cars.getCarType()+"租出了"+amount.size()+"次");
				//将数据放入map
				map2.put(""+i,""+amount.size());
			}
			//将数据放入外层map
			CarsRentMonth crm = new CarsRentMonth(map2, cars.getCarType());
			crmList.add(crm);
		}
		System.out.println("所有车信息==========="+crmList);
		return crmList;
	}
}
