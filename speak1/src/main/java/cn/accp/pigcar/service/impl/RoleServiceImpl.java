package cn.accp.pigcar.service.impl;


import cn.accp.pigcar.dao.RolesDao;
import cn.accp.pigcar.pojo.Roles;
import cn.accp.pigcar.service.RoleService;
import cn.accp.pigcar.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RolesDao rolesDao;

	@Override
	public boolean addMenusForRole(String roleName, List<Long> idLists) {
		// 这儿得做三件事，第一步添加角色，第二部根据角色查询到角色的id，第三步根据角色的id和模块的id进行关联
		// 实现角色权限的添加
		Roles role = null;
		// 第一步，添加角色
		Roles r = new Roles();
		r.setRolename(roleName);
		int x = rolesDao.insertOneRole(r);
		// 第二步，根据角色名称，查询角色id，如果添加成功，成功之后需要根据用户名查询id
		if (x > 0) {
			role = rolesDao.selectIdByRoleName(r);
		}
		// 第三步，关联信息,获得角色id，关联角色和模块的信息
		Long roleId = role.getRoleid();
		// 批量关联
		int isAdd = 0;
		boolean flag = false;
		for (Long menuId : idLists) {
			// 使用map传递参数
			Map<String, Long> map = new HashMap<String, Long>();
			map.put("roleid", roleId);
			map.put("menuid", menuId);
			isAdd = rolesDao.insertMenusForRole(map);
		}

		if (isAdd > 0) {
			// 如果添加成功
			flag = true;
		}

		return flag;
	}

	@Override
	public List<Roles> findAllRoles(PageBean<Roles> page, String rolename) {
		// 分页查询之前，得先查询全部，获得总条目数量
		// 获得数据的总条数
		// 此处采用map给mybatis传递参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rolename", rolename);
		map.put("start", page.getStartRow());// 开始的行号
		map.put("end", page.getEndRow());// 结束的行号
		// 然后在进行根据姓名的分页查询
		List<Roles> rolesList = rolesDao.selectRolesByNameByPage(map);

		return rolesList;
	}

	@Override
	public List<Roles> findAllRolesUseName(String rolename) {
		Roles role = new Roles();
		role.setRolename(rolename);
		List<Roles> roleAllList = rolesDao.selectAllRoles(role);
		return roleAllList;
	}

	@Override
	public Roles findOneByRoleid(Long roleid) {

		Roles role = rolesDao.selectByPrimaryKey(roleid);
		return role;
	}

	@Override
	public boolean updateMenusForRole(String roleName, List<Long> idLists) {
		// 修改角色的权限，迭代idLists集合，然后一个一个的进行修改，同理之前的先获取到用户的id，
		//但是这儿有一个问题？
		//问题是什么呢？当我们修改角色的时候，由于是批量修改，而且修改过后的角色的菜单数量不确定，可能多了
		//也可能少了，所以在我们修改角色信息之前，我们需要先接触角色关联的信息，然后在根据前台提交过来的模块id，进行批量添加
		// 第一步，查询用户的id

		Roles r = new Roles();
		r.setRolename(roleName);
		Roles role = rolesDao.selectIdByRoleName(r);

		// 第三步，关联信息,获得角色id，修改关联的模块的信息
		Long roleId = role.getRoleid();
		//然后删除角色的关联信息
		int isdelete = rolesDao.deleteMenusForRole(role);
		int isUpdate = 0;
		boolean flag = false;
		if (isdelete>0) {
			// 批量关联


			for (Long menuId : idLists) {
				// 使用map传递参数
				Map<String, Long> map = new HashMap<String, Long>();
				map.put("roleid", roleId);
				map.put("menuid", menuId);
				// 此处虽说是修改，但理论上也还是添加
				isUpdate = rolesDao.insertMenusForRole(map);
			}
			if (isUpdate > 0) {
				// 如果添加成功
				flag = true;
			}

		}
		return flag;
	}

	@Override
	public boolean deleteRoleById(Long roleid) {
		//删除之前先解除角色和和模块的关联
		Roles role = new Roles();
		role.setRoleid(roleid);
		//删除之前解除关联关系
		rolesDao.deleteMenusForRole(role);
		//删除角色信息
		int x = rolesDao.deleteRolesById(role);
		boolean flag = false;
		if (x>0) {
			//删除成功返回true
			flag = true;
		}
		return flag;
	}

}
