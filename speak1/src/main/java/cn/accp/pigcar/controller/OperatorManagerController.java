package cn.accp.pigcar.controller;


import cn.accp.pigcar.pojo.Cars;
import cn.accp.pigcar.pojo.Checktable;
import cn.accp.pigcar.pojo.Customers;
import cn.accp.pigcar.pojo.Renttable;
import cn.accp.pigcar.service.CarService;
import cn.accp.pigcar.service.CheckTableService;
import cn.accp.pigcar.service.CustService;
import cn.accp.pigcar.service.RentalTableService;
import cn.accp.pigcar.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统核心业务模块控制层
 * 客户租车还车
 *
 */
@RequestMapping("main")
@Controller
@CrossOrigin(allowCredentials = "true")
@ResponseBody()
public class OperatorManagerController {
	@Autowired
	private CustService custService;
	@Autowired
	private CarService carService;
	@Autowired
	private RentalTableService rtService;
	@Autowired
	private CheckTableService ctService;

	/**
	 * 绑定时间转换器，否则，提交日期参数将会产生400错误
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping("findCar")
	public List<Cars> findCar(@RequestParam("carType")String carType){
		Cars cars=new Cars();
		cars.setCarType(carType);
		cars.setCarDesc(carType);
		cars.setColor(carType);
		return carService.findCarBytype(cars);
	}
	/**
	 * 查询数据库是否有这个身份证
	 */
	@RequestMapping("findIdentity")
	public boolean findIdentity(String identity) throws IOException {
		Customers customers = custService.findOne(identity);
		if (null != customers && !"".equals(identity)) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 查询汽车的信息
	 */
	@RequestMapping("findCars")
	public Object findCars(HttpSession session){
		//查询全部汽车
		String indetity=(String)session.getAttribute("indetity");
		List<Cars> cars = carService.findAllCars();
		session.setAttribute("list", cars);
		session.setAttribute("indetity", indetity);
		Map<String,Object> h=new HashMap<>();
		h.put("list",cars);
		h.put("indetity",indetity);
		return h;
	}
	/**
	 * 预租车，生成租车单
	 * 通过租车单的id查询到相关的车信息
	 * 然后生成租车单
	 */
	@RequestMapping("preRentCar")
	public Map<String, Object> preRentCar(HttpSession session){
		//根据用户id，客户id和汽车id查询相关信息。
		String carNumber = (String) session.getAttribute("ccarNumber");
		String identity =(String) session.getAttribute("indetity");
		//通过carnumber查询car的信息
		Cars car = carService.getOneCar(carNumber);
		Customers customer = custService.findOne(identity);
		//查询完毕之后得生成一个当前时间给起租时间
		String date = MyUtil.getCurrentDate();
		//获得一个18位的随机数让其成为出租单id
		Long rentId = MyUtil.getRandomId();

		//数据获得完之后将其显示在页面上
		Map<String,Object> h=new HashMap<>();
		h.put("car", car);
		h.put("customer", customer);
		h.put("date", date);
		h.put("rentId", rentId);

		//之后到达出租单创建页面
		return h;
	}

	@RequestMapping("sevaCarNumber")
	public boolean sevaCarNumber(HttpSession session,String carNumber){
		session.setAttribute("ccarNumber",carNumber);
		return  true;
	}
	/**
	 * 将客户身份证携带的数据跳转到showcar界面
	 * @return
	 */
	@RequestMapping("goForShowCar")
	public boolean goForShowCar(String identity,HttpSession session){
		session.setAttribute("indetity", identity);
		return  true;
	}
	/**
	 * 添加出租单
	 * @return
	 */
	@RequestMapping("addRentTable")
	public Boolean addRentTable(@RequestParam("rentflag")Long rentflag, Renttable rent){
		boolean flag = rtService.addRentTable(rent);
		Cars car= carService.getOneCar(rent.getCarid());
		car.setIsRenting("1");
		int i= carService.updateCar(car);
		return flag;
	}
	/**
	 * 查询出租单表的信息，目的是为了响应ajax请求
	 */
	@RequestMapping("findRentTableId")
	public String findRentTableId(String tableid,HttpSession session) throws IOException{
		//查询出租单
		Renttable renttable = rtService.findRentalByRenTableId(tableid);
		if (null != renttable && !"".equals(renttable)) {
		return "true";
		}else{
			return "false";
		}

	}
	/**
	 * 查询检查单,然后生成检查单的信息
	 * 这儿有两点点需要动态生成
	 * 1、检查单号
	 * 2、检查时间
	 */
	@RequestMapping("findCheckTable")
	public Boolean findCheckTable(String tableid,HttpSession session){
		//生成一个检查单的id
		Long checkId = MyUtil.getRandomId();
		//生成系统当前时间
		String currentDate = MyUtil.getCurrentDate();
		//查询出租单
		Renttable renttable = rtService.findRentalByRenTableId(tableid);
		Map<String,Object> h=new HashMap<>();
		h.put("rent", renttable);
		h.put("checkId", checkId);
		h.put("checkDate", currentDate);
		session.setAttribute("checkTable",h);
		/*	return "operatorManager/createCheckTable";*/
		return true;
	}
	@RequestMapping("getfindCheckTable")
	public Object getfindCheckTable(HttpSession session){

		return session.getAttribute("checkTable");
	}
	/**
	 * 生成检查单，将检查单添加到数据库
	 */
	@RequestMapping("addCheck")
	public Boolean addCheck(Checktable checktable,Renttable rent,String carNumber){
		boolean flag = ctService.addCheckTable(checktable);
		Boolean ff=rtService.updateRentable(rent);
		Cars c= carService.getOneCar(carNumber);
		c.setIsRenting("0");
		  carService.updateCar(c);
		return flag;
	}

}
