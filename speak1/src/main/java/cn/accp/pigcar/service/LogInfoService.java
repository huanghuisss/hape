package cn.accp.pigcar.service;

import cn.accp.pigcar.pojo.Loginlogs;
import cn.accp.pigcar.pojo.Logs;
import cn.accp.pigcar.util.PageBean;

import java.util.List;

public interface LogInfoService {
	/**
	 * 条件查询所有的日志信息
	 */
	List<Logs> findLogInfoByIf(Logs log);
	/**
	 * 分页查询
	 */
	List<Logs> findLogInfoByPage(PageBean<Logs> page, Logs log);
	/**
	 * 查询登录信息，多条件查询
	 */
	List<Loginlogs> findLoginInfoByIf(Loginlogs logs);
	/**
	 * 分页查询登录日志信息
	 */
	List<Loginlogs> findLoginInfoByPage(PageBean<Loginlogs> page, Loginlogs logs);

}
