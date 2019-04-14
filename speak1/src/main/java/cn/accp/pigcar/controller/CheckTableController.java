package cn.accp.pigcar.controller;


import cn.accp.pigcar.pojo.Checktable;
import cn.accp.pigcar.service.CheckTableService;
import cn.accp.pigcar.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 检查单管理控制层
 *
 */
@Controller
@RequestMapping("check")
@ResponseBody
@CrossOrigin(allowCredentials = "true")
public class CheckTableController {
	@Autowired
	private CheckTableService checkService;

	/**
	 * 绑定时间转换器，否则，提交日期参数将会产生400错误
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	/**
	 * 检查单的多条件查询
	 */
	@RequestMapping("findCheckByIf")
	public Map<String,Object> findCheckByIf(Checktable check, HttpSession session, String currentPage){
		//获得当前页号
		String index = currentPage;
		PageBean<Checktable> page = new PageBean<Checktable>();
		//多条件查询的所有结果
		List<Checktable> byIfList = checkService.findCheckTableByIf(check);
		page.setTotalCount(byIfList.size());
		int currentIndex = 1;

		if (null != index && !"".equals(index) ) {
			currentIndex = Integer.parseInt(index);
		}
		//设置当前页
		System.out.println("当前页："+currentIndex);
		page.setIndex(currentIndex);
		//多条件的分页查询
		List<Checktable> list = checkService.findCheckByIf(check, page);
		//System.out.println(list.get(1).getRoles().getRolename());
		session.setAttribute("pageIndex", currentIndex);
		session.setAttribute("page", page);
		//req.setAttribute("userList", list);
		session.setAttribute("userList", list);
		Map<String,Object> h=new HashMap<>();
		h.put("pageIndex", currentIndex);
		h.put("page", page);
		h.put("cheaklist", list);
		return h;
	}

	@RequestMapping("sevaCheck")
	public Boolean sevaCheck(Checktable check, HttpSession session){
		session.setAttribute("secheck", check);
		return true;
	}
	@RequestMapping("getsevaCheck")
	public Checktable getsevaCheck(Checktable check, HttpSession session){
		Checktable c=(Checktable) session.getAttribute("secheck");
		return c;
	}
	/**
	 * 通过id查询检查单的信息
	 */
	@RequestMapping("findByCheckId")
	public boolean findByCheckId(@RequestParam("checkid")Long checkid,HttpSession session){

		Checktable ct = checkService.findCheckTableById(checkid);
		session.setAttribute("check", ct);
		return true;
	}

	@RequestMapping("getupdatecheak")
	public Checktable getupdatecheak(HttpSession session){

		Checktable ct = (Checktable) session.getAttribute("check");
		return ct;
	}
	/**
	 * 更新检查单
	 */
	@RequestMapping("updateCheck")
	public boolean updateCheck(Checktable check){
		boolean flag = checkService.updateCheckTable(check);
		return flag;
	}
	/**
	 * 删除检查单，通过id
	 */
	@RequestMapping("deleteByCheckId")
	public String deleteByCheckId(@RequestParam("checkid")Long checkid){
		boolean flag = checkService.deleteCheckTable(checkid);
		if (flag) {
			return "ok";
		}else{
			return "exception";
		}
	}
}
