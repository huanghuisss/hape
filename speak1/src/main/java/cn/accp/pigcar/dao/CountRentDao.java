package cn.accp.pigcar.dao;


import cn.accp.pigcar.pojo.Renttable;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * 统计出租单的信息mapper
 */
@Mapper
public interface CountRentDao {

    List<Renttable> countAllShouldPayPrice();

    List<Renttable> countRentCarCount();

}
