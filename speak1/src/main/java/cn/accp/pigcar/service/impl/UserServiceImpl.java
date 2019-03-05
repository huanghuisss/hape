package cn.accp.pigcar.service.impl;

import cn.accp.pigcar.dao.UserDao;
import cn.accp.pigcar.pojo.Users;
import cn.accp.pigcar.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public Users login(Users users) {
        if(userDao.select(users,-1,-1).size()!=0){
            return userDao.select(users,-1,-1).get(0);
        }
        return  null;
    }



    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
