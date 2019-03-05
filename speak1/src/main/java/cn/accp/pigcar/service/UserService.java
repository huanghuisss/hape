package cn.accp.pigcar.service;

import cn.accp.pigcar.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //用户登录
       Users login(Users users);
}
