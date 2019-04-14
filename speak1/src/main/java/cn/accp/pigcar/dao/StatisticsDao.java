package cn.accp.pigcar.dao;

import cn.accp.pigcar.pojo.Renttable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;


/**
 * creat by gaoyu
 * 2017年11月15日
 */
@Mapper
public interface StatisticsDao {
    //获取所有，租车信息
    List<Renttable> getAllStati(Map<String, Object> map);
    //查询单个
    //Renttable getOneStati(int tableid);
    /**
     * 查询单个，参数类型为Long
     */
    Renttable getOneStati(Long tableid);

    //通过汽车id查找
    List<Renttable> getAmountByCarIdMonth(Map<String,String> map);

    int getAllStaticount(String date);
}
