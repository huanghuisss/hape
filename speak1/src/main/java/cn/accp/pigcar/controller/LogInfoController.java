package cn.accp.pigcar.controller;


import cn.accp.pigcar.pojo.Loginlogs;
import cn.accp.pigcar.pojo.Logs;
import cn.accp.pigcar.service.LogInfoService;
import cn.accp.pigcar.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("log")
public class LogInfoController {
	@Autowired
	private LogInfoService logInfoService;
	/**
	 * 绑定时间转换器，否则，提交日期参数将会产生400错误
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * 分页查询所有日志
	 */
	@RequestMapping("findAllLog")
	public String findLog(String action, String username, Date actiontime, HttpServletRequest req){
		PageBean<Logs> page = new PageBean<Logs>();
		Logs log = new Logs();
		log.setAction(action);
		log.setUsername(username);
		log.setActiontime(actiontime);
		//需要在前台接受的分页参数，1、当前页数。2、每页需要显示条数
		String currentPage = req.getParameter("currentPage");
		int index = 1;
		if (null != currentPage && !"".equals(currentPage)) {
			index = Integer.parseInt(currentPage);
		}
		//把当前页设置进去
		page.setIndex(index);

		//获取每页需要显示的数目
		String totalCount = req.getParameter("totalCount");
		//默认5条
		int total = 5;
		if (null != totalCount && !"".equals(totalCount)) {
			total = Integer.parseInt(totalCount);
		}
		//将每页需要显示的页数设置进去
		page.setSize(total);

		//1、查询出所有的日志数量
		List<Logs> logList = logInfoService.findLogInfoByIf(log);

		//2、统计页数(根据总记录数计算总数)
		page.setTotalCount(logList.size());

		//3、分页查询
		List<Logs> pageList = logInfoService.findLogInfoByPage(page,log);
		req.setAttribute("page", page);
		req.setAttribute("pageIndex", index);
		req.setAttribute("pageList", pageList);
		return "systemManager/viewLog";
	}
	/**
	 * 痛果多条件查询登录信息并且分页显示
	 */
	@RequestMapping("findLoginInfoByIfByPage")
	public String findLoginInfoByIfByPage(HttpServletRequest req, Date logintime, Loginlogs logs){
		String loginname = req.getParameter("loginname");
		logs.setLoginname(loginname);
		//String logintime = req.getParameter("logintime");

		/*
		 * 分页查询总结：
		 * 	获取的分页参数
		 * 		1、当前页 2、每页显示条数 3、根据总记录条数计算多少页
		 *
		 * 然而做分页查询时，只需要两个参数，（所以在分页查询时，只需传递一个page对象，让其获得分页参数即可）
		 * 		1、开始索引 2、结束索引
		 * 然后再将分页对象和查询出来的对象设置到对象中去即可。
		 *
		 *
		 * */
		//req.getParameter("loginip");
		//req.getParameter("loginname");
		//req.getParameter("");
		//第一步：先查询出所有的数据
		PageBean<Loginlogs> page = new PageBean<Loginlogs>();
		String currentPage = req.getParameter("currentPage");
		//多条件查询
		List<Loginlogs> loginLogList = logInfoService.findLoginInfoByIf(logs);
		//设置所有的记录，计算有多少页
		page.setTotalCount(loginLogList.size());
		int index = 1;
		if (null != currentPage && !"".equals(currentPage)) {
			index = Integer.parseInt(currentPage);
		}
		//把当前页设置进去
		page.setIndex(index);

		//获取每页需要显示的数目
		String totalCount = req.getParameter("totalCount");
		//默认5条
		int total = 5;
		if (null != totalCount && !"".equals(totalCount)) {
			total = Integer.parseInt(totalCount);
		}
		//将每页需要显示的页数设置进去
		page.setSize(total);

		System.out.println(page.getStartRow()+"---"+page.getEndRow());
		List<Loginlogs> loginListByPage = logInfoService.findLoginInfoByPage(page,logs);
		req.setAttribute("page", page);
		req.setAttribute("pageIndex", index);
		req.setAttribute("loginList", loginListByPage);
		return "systemManager/showLoginLogInfo";
	}
}
