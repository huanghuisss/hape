package cn.accp.pigcar.service.impl;

import cn.accp.pigcar.dao.CountRentDao;
import cn.accp.pigcar.pojo.Renttable;
import cn.accp.pigcar.service.CountRentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CountRentServiceImpl implements CountRentService {
	@Resource
	private CountRentDao countRentDao;
	@Override
	public List<Renttable> countAllShouldPayPrice() {
		List<Renttable> countAllShouldPayPrice = countRentDao.countAllShouldPayPrice();
		return countAllShouldPayPrice;
	}
	@Override
	public List<Renttable> countRentCarCount() {
		List<Renttable> list = countRentDao.countRentCarCount();
		
		return list;
	}
	
}
