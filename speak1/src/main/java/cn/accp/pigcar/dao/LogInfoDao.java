package cn.accp.pigcar.dao;


import cn.accp.pigcar.pojo.Logs;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface LogInfoDao {
    /**
     * 条件查询所有的日志信息
     */
    List<Logs> selectLogInfoByIf(Logs log);
    /**
     * 多条件的分页查询
     */
    List<Logs> selectLogInfoByPage(Logs log);

}
