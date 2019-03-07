package cn.accp.pigcar.dao;

import cn.accp.pigcar.pojo.Users;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserDao {
    /***
     * 通过用户名和密码进行查询
     */
    Users selectUserByNameAndPwd(Users user);
    /**
     * 根据用户主键查询他的菜单信息
     */
    Users selectAllMenus(Users user);
    /**
     * 查询所有的用户
     */
    List<Users> selectAllUsers();
    /**
     * 添加用户
     */
    int insertUsers(Users user);
    /**
     * 查询所有用户信息
     */
    List<Users> selectAllUser();
    /**
     * 分页查询
     */
    List<Users> selectUserByPage(Map<String, Object> map);
    /**
     * 多条件查询
     */
    List<Users> selectUserByIf(Users user);
    /**
     * 多条件的分页查询
     */
    List<Users> selectUserByIfForPage(Users user);
    /**
     * 根据主键查询单个信息
     */
    Users selectOneUserByUname(Users user);
    /**
     * 修改用户信息
     */
    int updateUsers(Users user);
    /**
     * 通过主键删除
     */
    int deleteUserByUsername(Users user);




}
