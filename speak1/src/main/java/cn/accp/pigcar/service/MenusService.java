package cn.accp.pigcar.service;


import cn.accp.pigcar.pojo.Menus;
import cn.accp.pigcar.pojo.Roles;

import java.util.List;

public interface MenusService {
	/**
	 * 通过角色id查询出该角色下的所有菜单
	 */
	public List<Menus> findMenusList(Roles roleId);
}
