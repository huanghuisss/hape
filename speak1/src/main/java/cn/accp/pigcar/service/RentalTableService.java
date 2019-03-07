package cn.accp.pigcar.service;

import cn.accp.pigcar.pojo.Renttable;

import java.util.List;

public interface RentalTableService {
	/**
	 * 出租单的多条件查询
	 */
	List<Renttable> findRentalTableByIf(Renttable renttable);
	/**
	 * 通过出租单表的主键id去查询出租但表的信息
	 */
	Renttable findRentalByRenTableId(String tableid);
	/**
	 * 更新出租单表
	 */
	boolean updateRentable(Renttable renttable);
	/**
	 * 添加出租单表
	 */
	boolean addRentTable(Renttable rent);

}
