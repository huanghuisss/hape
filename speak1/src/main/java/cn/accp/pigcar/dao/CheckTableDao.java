package cn.accp.pigcar.dao;


import cn.accp.pigcar.pojo.Checktable;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface CheckTableDao {
    /**
     * 检查单表的多条件查询
     */
    List<Checktable> selectCheckByIf(Checktable check);
    /**
     * 通过主键查询检查单表的信息
     */
    Checktable selectCheckByPrimaryKey(Checktable ct);
    /**
     * 修改检查单
     */
    int updateCheckTable(Checktable check);
    /**
     * 通过id删除检查单表
     */
    int deleteCheckTableById(Checktable ct);
    /**
     * 添加检查单表
     */
    int insertCheckTable(Checktable checktable);

}
