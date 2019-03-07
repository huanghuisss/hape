package cn.accp.pigcar.service;


import cn.accp.pigcar.pojo.Menus;
import cn.accp.pigcar.pojo.Roles;
import cn.accp.pigcar.pojo.Users;
import cn.accp.pigcar.util.PageBean;

import java.util.List;

public interface UserService {
	/**
	 * 根据用户名和密码进行查询
	 */
	Users findUserByUNameAndPwd(Users user);
	/**
	 * 查询用户名为username下的所有的菜单
	 */
	List<Menus> findAllMenus(Users u);
	/**
	 * 查询所有角色
	 */
	List<Roles> findAllRoles();
	/**
	 * 添加用户
	 */
	boolean addUsers(Users user);
	/**
	 * 查询所有用户信息
	 */
	List<Users> finAllUser();
	/**
	 * 分页查询
	 */
	List<Users> findUserByPage(PageBean<Users> page);
	/**
	 * 多条件分页查询
	 */
	List<Users> findUserByIf(Users user, PageBean<Users> page);
	/**
	 * 多条件查询
	 */
	List<Users> findUserByIf(Users user);
	/**
	 * 根据主键查询用户信息
	 */
	Users findUserInfoByUName(String username);
	/**
	 * 修改密码
	 */
	boolean updateUsers(Users user);
	/**
	 * 通过主键删除用户信息
	 */
	boolean deleteUserByUsername(String username);

}
