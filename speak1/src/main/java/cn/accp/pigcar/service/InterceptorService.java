package cn.accp.pigcar.service;

public interface InterceptorService {
	//添加普通日志信息
	void saveInter(String flagName,String userName,String action,String clientIp);
}
