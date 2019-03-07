package cn.accp.pigcar.service.impl;


import cn.accp.pigcar.dao.LogInfoDao;
import cn.accp.pigcar.dao.LoginLogDao;
import cn.accp.pigcar.pojo.Loginlogs;
import cn.accp.pigcar.pojo.Logs;
import cn.accp.pigcar.service.LogInfoService;
import cn.accp.pigcar.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogInfoServiceImpl implements LogInfoService {
	@Resource
	private LogInfoDao logInfoDao;
	@Resource
	private LoginLogDao loginLogDao;
	@Override
	public List<Logs> findLogInfoByIf(Logs log) {
		List<Logs> logList = logInfoDao.selectLogInfoByIf(log);
		return logList;
	}
	public List<Logs> findLogInfoByPage(PageBean<Logs> page, Logs log) {
		log.setStart(page.getStartRow());
		log.setEnd(page.getEndRow());
		List<Logs> logList = logInfoDao.selectLogInfoByPage(log);
		
		return logList;
	}
	@Override
	public List<Loginlogs> findLoginInfoByIf(Loginlogs logs) {
		List<Loginlogs> loginList = loginLogDao.findAllLoginInfoByIf(logs);
		return loginList;
	}
	@Override
	public List<Loginlogs> findLoginInfoByPage(PageBean<Loginlogs> page,
											   Loginlogs logs) {
		logs.setStart(page.getStartRow());
		logs.setEnd(page.getEndRow());
		List<Loginlogs> loginList = loginLogDao.selectAllLoginInfoByPage(logs);
		
		
		return loginList;
	}
	

}
