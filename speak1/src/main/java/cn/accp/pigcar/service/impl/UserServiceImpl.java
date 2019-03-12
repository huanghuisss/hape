package cn.accp.pigcar.service.impl;

import cn.accp.pigcar.dao.MenusDao;
import cn.accp.pigcar.dao.RolesDao;
import cn.accp.pigcar.dao.UserDao;
import cn.accp.pigcar.pojo.Menus;
import cn.accp.pigcar.pojo.Roles;
import cn.accp.pigcar.pojo.Users;
import cn.accp.pigcar.service.UserService;
import cn.accp.pigcar.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private MenusDao menusDao;
	@Resource
	private RolesDao rolesDao;
	@Override
	public Users findUserByUNameAndPwd(Users user) {
		
		return userDao.selectUserByNameAndPwd(user);
	}
	@Override
	public List<Menus> findAllMenus(Users u) {
		//Users users = userDao.selectUserByNameAndPwd(u);
		List<Menus> menuses = menusDao.selectMenusByRoleId(u.getRoles());
		System.out.println("menuses="+menuses);
		Menus root = null;
		for (Menus menus : menuses) {
			if (menus.getMenuid() == 1) {
				root = menus;
			}
			for (Menus menus2 : menuses) {
				//如果menus2是menus的子节点
				if (menus.getMenuid().equals(menus2.getFatherid())) {
					//将menus2装到容器里面
					menus.getMenuList().add(menus2);
				}
			}
		}
		List<Menus> menuslist = new ArrayList<Menus>();
		menuslist.add(root);
		return menuslist;
	}
	@Override
	public List<Roles> findAllRoles() {
		List<Roles> roleList = rolesDao.selectAllRole();
		
		return roleList;
	}
	@Override
	public boolean addUsers(Users user) {
		int x = userDao.insertUsers(user);
		if (x>0) {
			return true;
		}else{
			return false;
		}
	}
	@Override
	public List<Users> finAllUser() {
		List<Users> users = userDao.selectAllUsers();
		return users;
	}
	@Override
	public List<Users> findUserByPage(PageBean<Users> page) {
		
		Map<String, Object> map = new HashMap<String,Object>();
		int start = page.getStartRow();
		int end = page.getEndRow();
		map.put("start", start);
		map.put("end", end);
 		List<Users> userList = userDao.selectUserByPage(map);
		
		return userList;
	}
	@Override
	public List<Users> findUserByIf(Users user) {
		
		List<Users> userList = userDao.selectUserByIf(user);
		
		return userList;
	}
	@Override
	public List<Users> findUserByIf(Users user, PageBean<Users> page) {
		user.setStart(page.getStartRow());
		user.setEnd(page.getEndRow());
		List<Users> userList = userDao.selectUserByIfForPage(user);
		return userList;
	}
	@Override
	public Users findUserInfoByUName(String username) {
		Users users = new Users();
		users.setUsername(username);
		Users user = userDao.selectOneUserByUname(users);
		return user;
	}
	@Override
	public boolean updateUsers(Users user) {
		int x = userDao.updateUsers(user);
		if (x>0) {
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean deleteUserByUsername(String username) {
		Users user = new Users();
		user.setUsername(username);
		int x = userDao.deleteUserByUsername(user);
		
		return x == 1;
	}
	

}
