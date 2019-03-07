package cn.accp.pigcar.dao;


import cn.accp.pigcar.pojo.Roles;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface RolesDao {

    /**
     * 添加角色
     */
    int insertOneRole(Roles role);
    /**
     * 根据角色名称查询角色id
     */
    Roles selectIdByRoleName(Roles r);
    /**
     * 关联roles和menus
     */
    int insertMenusForRole(Map<String, Long> map);
    /**
     * 查询全部角色信息，用roleName做条件判读，如果rolename不为空，则根据
     * rolename查询，否则查询全部角色信息
     */
    List<Roles> selectAllRoles(Roles role);
    /**
     * 根据角色名的分页查询
     */
    List<Roles> selectRolesByNameByPage(Map<String, Object> map);
    /**
     * 通过主键查询角色信息
     */
    Roles selectByPrimaryKey(Long roleid);

    /**
     * 解除角色和模块的关系
     */
    int deleteMenusForRole(Roles role);
    /**
     * 删除角色的信息
     */
    int deleteRolesById(Roles role);
    /**
     * 查询所有角色信息
     */
    List<Roles> selectAllRole();


}
