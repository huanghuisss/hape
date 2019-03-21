package cn.accp.pigcar.controller;

import cn.accp.pigcar.pojo.Renttable;
import cn.accp.pigcar.service.RentalTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 出租单管理
 *
 */
@Controller
@RequestMapping("rentTable")
@CrossOrigin(allowCredentials = "true")
public class RentalTableController {
	@Autowired
	private RentalTableService rentalTableService;
	/**
	 * 绑定时间转换器，否则，提交日期参数将会产生400错误
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	/**
	 * 多条件查询
	 */
	@RequestMapping("findRentalTableByIf")
	@ResponseBody
	public Object findRentalTableByIf(Renttable renttable, HttpSession session){
		List<Renttable> rentList = rentalTableService.findRentalTableByIf(renttable);
		session.setAttribute("rentList", rentList);
		System.out.println(renttable);
		return rentList;
	}
	/**
	 * 预更新，跟新之前执行查询操作，将结果显示到更新界面
	 */
	@RequestMapping("preUpdate")
	public String preUpdate(@RequestParam("tableid")String tableid, HttpServletRequest req){
		//查询
		Renttable renttable = rentalTableService.findRentalByRenTableId(tableid);

		req.setAttribute("rent", renttable);

		return "operatorManager/updateRenttable";
	}
	/**
	 * 执行更新操作
	 */
	@RequestMapping("updateRentTable")
	public String updateRentTable(@RequestParam("rentflag")Long rentflag ,Renttable renttable,HttpServletRequest req){
		boolean flag = rentalTableService.updateRentable(renttable);
		if (flag) {
			return "ok";
		}
		return "exception";
	}
}
