package cn.accp.pigcar.controller;

import cn.accp.pigcar.pojo.CarsRentMonth;
import cn.accp.pigcar.pojo.Renttable;
import cn.accp.pigcar.service.StatisticsService;
import cn.accp.pigcar.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	@Autowired
	private StatisticsService service;

	@RequestMapping("/getAllStati")
	public String getAllStati(HttpServletRequest req, HttpServletResponse resp) {
		List<Renttable> allStati = service.getAllStati();
		for (Renttable renttable : allStati) {
			System.out.println("查到租赁信息=====" + renttable);
		}
		req.setAttribute("allStati", allStati);
		return "operatorStatistics/viewMonthReturnCarResult";
	}

	@RequestMapping("/getOneStati")
	public String getOneStati(HttpServletRequest req, HttpServletResponse resp) {
		// 获得相应的出租表id
		Long tableid = 0L;
		String sTableid = req.getParameter("tableid");
		if (sTableid != null && !"".equals(sTableid)) {
			//tableid = Integer.parseInt(sTableid);
			tableid = Long.parseLong(sTableid);
		}
		//数据库查找
		Renttable oneStati = service.getOneStati(tableid);
		//Renttable oneStati = service.getOneStati(tableid);
		req.setAttribute("rent", oneStati);
		return "operatorStatistics/findMonthReturnCarByInfo";
	}
	/**
	 * 业务查询——按月份查询——折线图
	 */
	@RequestMapping("/getMonthAmount")
	public String getMonthAmount(HttpServletRequest req,
								 HttpServletResponse resp) {
		List<CarsRentMonth> monthAmount = service.getMonthAmount();
		System.out.println("================="+monthAmount);
		String str1 = StringUtil.formatString(monthAmount);
		//赋值给前台
		req.setAttribute("strformat", str1);
		return "operatorStatistics/carRentByMonthAmount";
	}
}
