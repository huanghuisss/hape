package cn.accp.pigcar.dao;


import cn.accp.pigcar.pojo.Loginlogs;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface LoginLogDao {
    /**
     * 多条件查询用户登录信息
     */
    List<Loginlogs> findAllLoginInfoByIf(Loginlogs logs);
    /**
     * 分页查询登录日志信息
     */
    List<Loginlogs> selectAllLoginInfoByPage(Loginlogs logs);

}
