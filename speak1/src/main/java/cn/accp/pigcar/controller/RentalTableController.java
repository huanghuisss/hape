package cn.accp.pigcar.controller;

import cn.accp.pigcar.pojo.Cars;
import cn.accp.pigcar.pojo.Renttable;
import cn.accp.pigcar.pojo.Users;
import cn.accp.pigcar.service.CarService;
import cn.accp.pigcar.service.RentalTableService;
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
 * 出租单管理
 *
 */
@Controller
@RequestMapping("rentTable")
@CrossOrigin(allowCredentials = "true")
@ResponseBody()
public class RentalTableController {
	@Autowired
	private RentalTableService rentalTableService;
	@Autowired
	private CarService carService;
	/**
	 * 绑定时间转换器，否则，提交日期参数将会产生400错误
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	/**
	 * 多条件查询
	 *
	 */

	@RequestMapping("findRentalTableByIf")
	public Object findRentByIf(Renttable renttable){
		return rentalTableService.findRentalTableByIf(renttable);
	}

	@RequestMapping("findRentalTableByIfpage")
	@ResponseBody
	public Map<String,Object> findRentByIfpage(HttpSession session, String currentPage, Renttable rent){
		//获得当前页号
		String index = currentPage;
		PageBean<Renttable> page = new PageBean<Renttable>();
		//多条件查询的所有结果
		page.setTotalCount(rentalTableService.selectRentalTableByIfCount(rent));
		int currentIndex = 1;
		if (null != index &&	 !"".equals(index) ) {
			currentIndex = Integer.parseInt(index);
		}
		//设置当前页
		System.out.println("当前页："+currentIndex);
		page.setIndex(currentIndex);
		//多条件的分页查询
		List<Renttable> list = rentalTableService.findRentByIf(rent, page);
		session.setAttribute("pageIndex", currentIndex);
		session.setAttribute("page", page);
		session.setAttribute("rentlist", list);
		Map<String,Object> h=new HashMap<>();
		h.put("pageIndex", currentIndex);
		h.put("page", page);
		h.put("rentlist", list);
		return h;
	}
	@RequestMapping("saveRent")
	public boolean saveRent(Renttable renttable,HttpSession session){
		session.setAttribute("seRent",renttable);
		return true;
	}

	@RequestMapping("getsaveRent")
	public Object getsaveRent(HttpSession session){
		return session.getAttribute("seRent");
	}
	/**
	 * 预更新，跟新之前执行查询操作，将结果显示到更新界面
	 */
	@RequestMapping("preUpdate")
	public Boolean preUpdate(@RequestParam("tableid")String tableid, HttpSession session){
		//查询
		Renttable renttable = rentalTableService.findRentalByRenTableId(tableid);
		session.setAttribute("rentbianji", renttable);

		return true;
	}

	@RequestMapping("getpreUpdate")
	public Renttable getpreUpdate(HttpSession session){
		Renttable ren=(Renttable) session.getAttribute("rentbianji");
		return ren;
	}
	/**
	 * 执行更新操作
	 */
	@RequestMapping("updateRentTable")
	public Boolean updateRentTable(Renttable renttable,String carnumber,HttpSession session){
		if(renttable.getRentflag()==1){
			Cars s= carService.getOneCar(carnumber);
			s.setIsRenting("0");
			carService.updateCar(s);
		}
		return rentalTableService.updateRentable(renttable);
	}
}
