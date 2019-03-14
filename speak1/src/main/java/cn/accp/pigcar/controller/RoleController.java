package cn.accp.pigcar.controller;


import cn.accp.pigcar.pojo.Menus;
import cn.accp.pigcar.pojo.Roles;
import cn.accp.pigcar.service.MenusService;
import cn.accp.pigcar.service.RoleService;
import cn.accp.pigcar.service.UserService;
import cn.accp.pigcar.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController{
	@Autowired
	private MenusService menusService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	/**
	 * 添加角色信息之前进行角色信息的查询
	 */
	@RequestMapping("findRole")
	public String findAllRole(@RequestParam("roleid") Long roleid,
							  HttpServletRequest req) {
		Roles role = new Roles();
		role.setRoleid(roleid);
		List<Menus> menus = menusService.findMenusList(role);
		req.setAttribute("menus", menus);
		return "systemManager/addRole";
	}

	/**
	 * 添加角色和对添加的角色授予相关的模块的权限
	 */
	@RequestMapping("addRole")
	public String addRole(@RequestParam("roleName") String roleName,
						  HttpServletRequest req) {
		// 查询到系统管理员的MenusList
		Roles role = new Roles();
		role.setRoleid(1L);
		List<Menus> menus = menusService.findMenusList(role);
		// 用于保存选中的所有模块加菜单的id
		List<Long> IdLists = new ArrayList<Long>();
		// 手动给他设置顶层模块的id
		IdLists.add(1L);
		for (Menus menus2 : menus) {
			String fatherId = "";
			// 表示它们从属于系统管理员
			if (menus2.getFatherid() == 1) {
				// 获取到menuid，即子菜单的id
				Long menuid = menus2.getMenuid();
				// 获取到系统管理员下的子模块的id
				fatherId = req.getParameter("f" + menuid);
				if (!"".equals(fatherId) && null != fatherId) {
					// 获取子模块下的子菜单的id
					String[] sonIds = req.getParameterValues("s" + fatherId);
					// 获取到之后，得对string数组进行转换，转换成为Long[]数组
					for (String sonId : sonIds) {
						// 将子从菜单id添加进集合
						IdLists.add(Long.parseLong(sonId));
					}
					// 将子模块的id添加进集合
					IdLists.add(Long.parseLong(fatherId));
				}
			}
		}
		// 调用业务层，将角色和模块关联添加,如果角色名称为空则不进行添加
		if (null != roleName && !"".equals(roleName)) {
			boolean flag = roleService.addMenusForRole(roleName, IdLists);
		}

		return "ok";
	}

	/**
	 * 查询所有角色的分页查询
	 */
	@RequestMapping("findAllRole")
	public String findRole(@RequestParam("roleName") String roleName,
						   HttpServletRequest req) {
		String pageIndex = req.getParameter("pageIndex");

		PageBean<Roles> page = new PageBean<Roles>();
		if (null != pageIndex && !"".equals(pageIndex)) {
			// 获得当前页
			int index = Integer.parseInt(pageIndex);
			page.setIndex(index);
		}
		System.out.println(roleName + "当前页码：" + page.getIndex());
		// 查询到记录总数
		List<Roles> lists = roleService.findAllRolesUseName(roleName);

		// 根据角色名称的分页模糊查询
		List<Roles> roleList = roleService.findAllRoles(page, roleName);
		// page.setTotalCount(roleList.size());
		page.setTotalCount(lists.size());
		req.setAttribute("page", page);
		req.setAttribute("roleList", roleList);
		return "systemManager/viewAllRole";
	}

	/**
	 * 通过id查询role信息
	 */
	@RequestMapping("queryRoleById")
	public String queryRoleById(@RequestParam("roleid") Long roleid,
								HttpServletRequest req) {

		// 要更新。首先得先查询，然后，再将查询结果写入更新列表
		Roles role = roleService.findOneByRoleid(roleid);
		// 获得管理员所管理的菜单,方便修改用户权限
		Roles admin = new Roles();
		admin.setRoleid(1L);
		admin.setRolename("管理员");
		//查询管理员具有的菜单功能
		List<Menus> adminMenus = menusService.findMenusList(admin);
		//查询选中的当前角色具有的菜单功能
		List<Menus> roleMenu = menusService.findMenusList(role);
		//选中当前角色拥有的菜单
		for (Menus menus1 : adminMenus) {
			for (Menus menus2 : roleMenu) {
				if (menus1.getMenuid() == menus2.getMenuid()) {
					menus1.setIsChecked("Checked");
				}
			}
		}


		req.setAttribute("role", role);
		req.setAttribute("menus", adminMenus);
		return "systemManager/updateRole";
	}

	@RequestMapping("updateRole")
	public String updateRole(@RequestParam("roleName") String roleName,
							 HttpServletRequest req) {
		// 查询到系统管理员的MenusList,用于获取提交的权限
		Roles role = new Roles();
		role.setRoleid(1L);
		List<Menus> menus = menusService.findMenusList(role);
		// 用于保存选中的所有模块加菜单的id
		List<Long> IdLists = new ArrayList<Long>();
		// 手动给他设置顶层模块的id
		IdLists.add(1L);
		for (Menus menus2 : menus) {
			String fatherId = "";
			// 表示它们从属于系统管理员
			if (menus2.getFatherid() == 1) {
				// 获取到menuid，即子菜单的id
				Long menuid = menus2.getMenuid();
				// 获取到系统管理员下的子模块的id
				fatherId = req.getParameter("f" + menuid);
				if (!"".equals(fatherId) && null != fatherId) {
					// 获取子模块下的子菜单的id
					String[] sonIds = req.getParameterValues("s" + fatherId);
					// 获取到之后，得对string数组进行转换，转换成为Long[]数组
					for (String sonId : sonIds) {
						// 将子从菜单id添加进集合
						IdLists.add(Long.parseLong(sonId));
					}
					// 将子模块的id添加进集合
					IdLists.add(Long.parseLong(fatherId));
				}
			}
		}
		boolean flag = false;
		// 调用业务层，将角色和模块关联添加,如果角色名称为空则不进行添加
		if (null != roleName && !"".equals(roleName)) {
			flag = roleService.updateMenusForRole(roleName, IdLists);
		}
		//更新结束之后，应该查询角色的信息4
		if (flag) {
			return "ok";
		}else{
			return "exception";
		}
	}

	@RequestMapping("deleteRoleById")
	public String deleteRoleById(@RequestParam("roleid") Long roleid){

		boolean flag = roleService.deleteRoleById(roleid);
		if (flag) {
			return "ok";
		}else{
			return "exception";
		}

	}
}
