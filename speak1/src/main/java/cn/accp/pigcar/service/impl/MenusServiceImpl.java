package cn.accp.pigcar.service.impl;


import cn.accp.pigcar.dao.MenusDao;
import cn.accp.pigcar.pojo.Menus;
import cn.accp.pigcar.pojo.Roles;
import cn.accp.pigcar.service.MenusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenusServiceImpl implements MenusService {
	@Resource
	private MenusDao menusDao;
	
	@Override
	public List<Menus> findMenusList(Roles roleId) {
		List<Menus> menusList = menusDao.selectMenusByRoleId(roleId);
		return menusList;
	}
	
	
	
}
