package cn.accp.pigcar.dao;


import cn.accp.pigcar.pojo.Loginlogs;
import cn.accp.pigcar.pojo.Logs;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface LogDao {
    // 添加普通日志信息
    void saveInter(Logs log);
    // 添加登录日志
    void saveLoginInter(Loginlogs log);
}
