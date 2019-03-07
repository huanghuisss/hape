package cn.accp.pigcar.service;


import cn.accp.pigcar.pojo.Roles;
import cn.accp.pigcar.util.PageBean;

import java.util.List;

public interface RoleService {
	/**
	 * 将角色和模块关联添加
	 */
	boolean addMenusForRole(String roleName,List<Long> idLists);
	/**
	 * 根据角色名的分页查询，查询全部角色
	 */
	List<Roles> findAllRoles(PageBean<Roles> page, String roleName);
	/**
	 * 使用角色名做条件查询
	 */
	List<Roles> findAllRolesUseName(String roleName);
	/**
	 * 通过角色id进行查询单个角色信息
	 */
	Roles findOneByRoleid(Long roleid);
	/**
	 * 修改该角色的权限
	 */
	boolean updateMenusForRole(String roleName, List<Long> idLists);
	/**
	 * 通过角色的id删除角色的信息
	 */
	boolean deleteRoleById(Long roleid);

}
