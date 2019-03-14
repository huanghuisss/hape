package cn.accp.pigcar.controller;


import cn.accp.pigcar.pojo.Checktable;
import cn.accp.pigcar.service.CheckTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 检查单管理控制层
 *
 */
@Controller
@RequestMapping("check")
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
	public String findCheckByIf(@RequestParam("tableid")Long tableid, Checktable check, HttpServletRequest req){
		List<Checktable> ck = checkService.findCheckTableByIf(check);
		req.setAttribute("CheckList", ck);
		return "operatorManager/viewCheckTables";
	}
	/**
	 * 通过id查询检查单的信息
	 */
	@RequestMapping("findByCheckId")
	public String findByCheckId(@RequestParam("checkid")Long checkid,HttpServletRequest req){

		Checktable ct = checkService.findCheckTableById(checkid);
		req.setAttribute("check", ct);
		return "operatorManager/updateCheckTable";
	}
	/**
	 * 更新检查单
	 */
	@RequestMapping("updateCheck")
	public String updateCheck(@RequestParam("checkid")Long checkid,Checktable check){
		boolean flag = checkService.updateCheckTable(check);
		if (flag) {
			return "ok";
		}
		return "exception";
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
