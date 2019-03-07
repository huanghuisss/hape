package cn.accp.pigcar.dao;

import cn.accp.pigcar.pojo.Menus;
import cn.accp.pigcar.pojo.Roles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenusDao {
    /**
     * 通过角色id查询出该角色下的所有菜单
     */
    List<Menus> selectMenusByRoleId(Roles roles);
}
