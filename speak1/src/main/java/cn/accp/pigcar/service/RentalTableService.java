package cn.accp.pigcar.service;

import cn.accp.pigcar.dao.RentalTableDao;
import cn.accp.pigcar.pojo.Renttable;
import cn.accp.pigcar.pojo.Users;
import cn.accp.pigcar.util.PageBean;

import java.util.List;
import java.util.Map;

public interface RentalTableService {
	/**
	 * 出租单的多条件查询
	 */
	List<Renttable> findRentalTableByIfpage(Map<String,Object> map);

	List<Renttable> findRentalTableByIf(Renttable renttable);
	/**
	 * 通过出租单表的主键id去查询出租但表的信息
	 */
	Renttable findRentalByRenTableId(String tableid);
	/**
	 * 更新出租单表
	 */
	boolean updateRentable(Renttable renttable);

	int  selectRentalTableByIfCount(Renttable renttable);
	/**
	 * 添加出租单表
	 */
	boolean addRentTable(Renttable rent);

	List<Renttable> findRentByIf(Renttable rent, PageBean<Renttable> page);
}
