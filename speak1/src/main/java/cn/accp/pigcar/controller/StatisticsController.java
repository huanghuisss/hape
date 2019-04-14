package cn.accp.pigcar.controller;

import cn.accp.pigcar.pojo.CarsRentMonth;
import cn.accp.pigcar.pojo.Renttable;
import cn.accp.pigcar.service.StatisticsService;
import cn.accp.pigcar.util.PageBean;
import cn.accp.pigcar.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/statistics")
@CrossOrigin(allowCredentials = "true")
@ResponseBody()
public class StatisticsController {
	@Autowired
	private StatisticsService service;

	@RequestMapping("/getAllStati")
	public Map<String,Object> getAllStati(HttpSession session, String currentPage) {
		//获得当前页号
		String index = currentPage;
		PageBean<Renttable> page = new PageBean<Renttable>();
		//多条件查询的所有结果
		page.setTotalCount(service.getAllStaticount());
		int currentIndex = 1;
		if (null != index &&	 !"".equals(index) ) {
			currentIndex = Integer.parseInt(index);
		}
		//设置当前页
		System.out.println("当前页："+currentIndex);
		page.setIndex(currentIndex);
		//多条件的分页查询
		List<Renttable> list = service.getAllStati(page);
		session.setAttribute("pageIndex", currentIndex);
		session.setAttribute("page", page);
		session.setAttribute("rentlist", list);
		Map<String,Object> h=new HashMap<>();
		h.put("pageIndex", currentIndex);
		h.put("page", page);
		h.put("rentlist", list);
		return h;
	}

	@RequestMapping("/getOneStati")
	public boolean getOneStati(HttpSession session,Long tableid) {
		// 获得相应的出租表id
		//数据库查找


		Renttable oneStati = service.getOneStati(tableid);
		session.setAttribute("rentoneStati", oneStati);
		return true;
	}

	@RequestMapping("/getgetOneStati")
	public Renttable getOneStati(HttpSession session) {
		Renttable s=(Renttable)session.getAttribute("rentoneStati");
		return s;
	}
	/**
	 * 业务查询——按月份查询——折线图
	 */
	@RequestMapping("/getMonthAmount")
	public List<Map<String, Object>> getMonthAmount(
								 HttpSession session) {
		List<CarsRentMonth> monthAmount = service.getMonthAmount();
		System.out.println("================="+monthAmount);
		//赋值给前台
		return StringUtil.formatString(monthAmount);
	}
}
