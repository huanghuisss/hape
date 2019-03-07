package cn.accp.pigcar.service.impl;


import cn.accp.pigcar.dao.LogDao;
import cn.accp.pigcar.pojo.Loginlogs;
import cn.accp.pigcar.pojo.Logs;
import cn.accp.pigcar.service.InterceptorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * creat by gaoyu 2017年11月15日
 */

/*
 * flag值说明：
 */
@Service
public class InterceptorServiceImpl implements InterceptorService {
	@Resource
	private LogDao logDao;

	/**
	 * 添加普通日志 
	 * id：自增长 id 
	 * username：用户 
	 * action：请求路径 
	 * actiontime：请求时间 
	 * flag：标识
	 * 
	 */
	@Override
	public void saveInter(String flagName, String username, String action,String clientIp) {
		// 初始化标签
		long flag = 0;
		// 对应 controller里面的方法
		// =============汽车==============
		if ("addCar".equals(flagName)) {
			System.out.println("添加汽车10");
			flag = 10;
		} else if ("deleteOne".equals(flagName)) {
			System.out.println("删除汽车12");
			flag = 12;
		} else if ("updateCar".equals(flagName)) {
			System.out.println("修改汽车11");
			flag = 11;
			// =============客户==============
		} else if ("addCust".equals(flagName)) {
			System.out.println("添加客户20");
			flag = 20;
		} else if ("deleteCust".equals(flagName)) {
			System.out.println("删除客户22");
			flag = 22;
		} else if ("updateCust".equals(flagName)) {
			System.out.println("修改客户21");
			flag = 21;
			// =============用户==============
		} else if ("addUsers".equals(flagName)) {
			System.out.println("添加添加用户1");
			flag = 1;
		} else if ("deletelogDao".equals(flagName)) {
			System.out.println("删除用户4");
			flag = 4;
		} else if ("updateUser".equals(flagName)) {
			System.out.println("修改用户2");
			flag = 2;
		} else if ("updatePwd".equals(flagName)) {
			System.out.println("用戶修改密碼3");
			flag = 3;
			// =============角色==============
		} else if ("addRole".equals(flagName)) {
			System.out.println("添加角色40");
			flag = 40;
		} else if ("deleteRoleById".equals(flagName)) {
			System.out.println("删除角色42");
			flag = 42;
		} else if ("updateRole".equals(flagName)) {
			System.out.println("修改角色41 ");
			flag = 41;
			// =============检查单/出租单==============
		} else if ("addRentTable".equals(flagName)) {
			System.out.println("生成出租30");
			flag = 30;
		} else if ("deleteByCheckId".equals(flagName)) {
			System.out.println("删除检查单32");
			flag = 32;
		} else if ("updateCheck".equals(flagName)) {
			System.out.println("修改检查单31");
			flag = 31;
		} else if ("updateRentTable".equals(flagName)) {
			System.out.println("修改出租单33");
			flag = 33;
			// =============登录日志==============
		} else if("login".equals(flagName)){
			//登录请求
			flag=0;
			Loginlogs log = new Loginlogs(0l, username, clientIp, new Date());
			logDao.saveLoginInter(log);
		}

		if(flag!=0){
			Logs log = new Logs(0l, username, action, new Date(), flag);
			logDao.saveInter(log);
		}else{
			System.out.println("非增删改方法");
		}
	}
}
