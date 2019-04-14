package cn.accp.pigcar.dao;


import cn.accp.pigcar.pojo.Renttable;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface RentalTableDao {
    /**
     * 出租单表的多条件查询
     */
    List<Renttable> selectRentalTableByIfpage(Map<String,Object> map);
    List<Renttable> selectRentalTableByIf(Renttable renttable);

    /**
     * 通过主键查询出租单表的信息
     */
    Renttable selectRentaalTableByPrimaryKey(Renttable renttable);
    /**
     * 更新出租单表
     */
    int updateRenttable(Renttable renttable);
    /**
     * 添加出租单表
     */
    int insertRenttable(Renttable rent);

    int  selectRentalTableByIfCount(Renttable renttable);

}
