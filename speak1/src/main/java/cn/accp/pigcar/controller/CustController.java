package  cn.accp.pigcar.controller;


import cn.accp.pigcar.pojo.Customers;
import cn.accp.pigcar.service.CustService;
import cn.accp.pigcar.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class CustController {

	@Autowired
	private CustService custService;

//	/**
//	 * 模糊查询
//	 */
//	@RequestMapping("/custLike")
//	public String custLike(Customers cust){
//
//		System.out.println("cust");
//
//		Map<String,Object> map = new HashMap<String, Object>();
//		//添加客户属性所需数据
//		map.put("identity", cust.getIdentity());
//		map.put("custname", cust.getCustname());
//		map.put("phone", cust.getPhone());
//		map.put("career", cust.getCareer());
//		map.put("address", cust.getAddress());
//		map.put("sex", cust.getSex());
//
//		List<Customers> custLike = custService.getAllCustByPage(map);
//
//		return "redirect:/car/user/allCustByPage";
//	}


	/**
	 * 修改1---查询一个
	 */
	@RequestMapping("/findOne")
	public String findOne(String identity, Map<String,Object> map){

		Customers cust = custService.findOne(identity);

		map.put("cust", cust);

		return "forward:/custManager/updateCustomers.jsp";
	}
	/**
	 * 修改2---update修改
	 */
	@RequestMapping("/updateCust")
	public String updateCust(Customers cust){

		System.out.println("666"+cust);

		custService.updateCust(cust);

		return "redirect:/car/user/allCustByPage";
	}
	/**
	 * 修改密码
	 */
	@RequestMapping("/updateCust1")
	public String updateCust1(Customers cust){

		System.out.println("哈哈哈");
		System.out.println(cust);

		custService.updateCust(cust);

		return "redirect:/car/user/findOne";
	}


	/**
	 * 删除一个客户---通过身份id
	 */
	@RequestMapping("/deleteCust")
	public String deleteCust(String identity){

		System.out.println(identity);

		custService.deleteCust(identity);

		return "redirect:/car/user/allCustByPage";
	}



	/**
	 * 查询所有的客户---应该使用分页
	 */
	@RequestMapping("/allCustByPage")
	public String allCustByPage(HttpSession session, Model model, String size, String page, Customers cust){

		//System.out.println(cust);

		PageBean pb = new PageBean();

		//  获得每一页的长度 --select
//		String  size = req.getParameter("size");
		if(size!=null){    					//只有当第一次访问的时候，会为null；   不可能出现      "".equals(size)
			int  size1 = Integer.parseInt(size);
			pb.setSize(size1);
		}

		// 1    从前台获取要查询的页数
//		 String page = req.getParameter("page");
		int p = 1;
		if(!"".equals(page)  &&   page!=null){
			p = Integer.parseInt(page);
		}
		pb.setIndex(p);

		// 2    计算尾页
		List<Customers> allCust = custService.getAllCust(cust);
		int count = allCust.size();
		pb.setTotalCount(count);

		//调用分页
		int start = pb.getStartRow();
		int end = pb.getEndRow();

		Map<String,Object> map = new HashMap<String, Object>();
		//添加客户属性所需数据
		map.put("identity", cust.getIdentity());
		map.put("custname", cust.getCustname());
		map.put("phone", cust.getPhone());
		map.put("career", cust.getCareer());
		map.put("address", cust.getAddress());
		map.put("sex", cust.getSex());
		//添加分页所需数据
		map.put("end", end);
		map.put("start", start);
		List<Customers> allCustByPage = custService.getAllCustByPage(map);

		for (Customers customers : allCustByPage) {
			System.out.println(customers);
		}

		model.addAttribute("allCustByPage", allCustByPage);
		model.addAttribute("pb", pb);

		//model.addAttribute("cust", cust);
		session.setAttribute("cust", cust);

		return "custManager/viewCustomers";
	}
	/**
	 * 查询所有的客户---应该使用分页 22222222
	 */
	@RequestMapping("/allCustByPage2")
	public String allCustByPage2(HttpSession session,Model model,String size,String page){

		//分页时模糊查询   不从前台获取  而是从session中获取
		Customers cust = (Customers) session.getAttribute("cust");

		System.out.println("从session中获取的cust"+cust);

		PageBean pb = new PageBean();

		//  获得每一页的长度 --select
//		String  size = req.getParameter("size");
		if(size!=null){    					//只有当第一次访问的时候，会为null；   不可能出现      "".equals(size)
			int  size1 = Integer.parseInt(size);
			pb.setSize(size1);
		}

		// 1    从前台获取要查询的页数
//		 String page = req.getParameter("page");
		int p = 1;
		if(!"".equals(page)  &&   page!=null){
			p = Integer.parseInt(page);
		}
		pb.setIndex(p);

		// 2    计算尾页
		List<Customers> allCust = custService.getAllCust(cust);
		int count = allCust.size();
		pb.setTotalCount(count);

		//调用分页
		int start = pb.getStartRow();
		int end = pb.getEndRow();

		Map<String,Object> map = new HashMap<String, Object>();
		//添加客户属性所需数据
		map.put("identity", cust.getIdentity());
		map.put("custname", cust.getCustname());
		map.put("phone", cust.getPhone());
		map.put("career", cust.getCareer());
		map.put("address", cust.getAddress());
		map.put("sex", cust.getSex());
		//添加分页所需数据
		map.put("end", end);
		map.put("start", start);
		List<Customers> allCustByPage = custService.getAllCustByPage(map);

		for (Customers customers : allCustByPage) {
			System.out.println(customers);
		}

		model.addAttribute("allCustByPage", allCustByPage);
		model.addAttribute("pb", pb);
		//model.addAttribute("cust", cust);

//		session.setAttribute("cust", cust);

		return "custManager/viewCustomers";
	}

//	/**
//	 * 查询所有的客户
//	 */
//	@RequestMapping("/allCust")
//	public String allCust(Model model){
//
//		List<Customers> allCust = custService.getAllCust();
//		for (Customers customers : allCust) {
//			System.out.println(customers);
//		}
//
//		model.addAttribute("allCust", allCust);
//
//		return "custManager/viewCustomers";
//	}


	/**
	 * 新增一个客户
	 */
	@RequestMapping("/addCust")
	public String addCust(Customers cust){

		System.out.println("添加的客户："+cust);

		Customers saveCust = custService.saveCust(cust);

		return "redirect:/car/user/allCustByPage";
	}
}
