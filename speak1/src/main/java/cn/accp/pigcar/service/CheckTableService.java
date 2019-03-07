package cn.accp.pigcar.service;


import cn.accp.pigcar.pojo.Checktable;

import java.util.List;

public interface CheckTableService {
	/**
	 * 检查单表多条件查询
	 */
	List<Checktable> findCheckTableByIf(Checktable check);
	/**
	 * 通过检查单id查询检查单表的信息
	 */
	Checktable findCheckTableById(Long checkid);
	/**
	 * 修改检查单
	 */
	boolean updateCheckTable(Checktable check);
	/**
	 * 删除检查单表，通过id
	 */
	boolean deleteCheckTable(Long checkid);
	/**
	 * 添加检查单
	 */
	boolean addCheckTable(Checktable checktable);

}
