package cn.accp.pigcar.dao;

import cn.accp.pigcar.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserDao {
    //分页查找所有用户
    List<Users> select(@Param("users")Users users,@Param("sta")int sta,@Param("end")int end);

    //添加用户
    int insert(Users users);

    //修改用户
    int update(Users users);

    //删除用户
    int delete(Users users);

    //查询所有用户总数量
    int selectCount(Users users);


}
