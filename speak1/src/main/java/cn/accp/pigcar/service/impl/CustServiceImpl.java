package cn.accp.pigcar.service.impl;


import cn.accp.pigcar.dao.CustDao;
import cn.accp.pigcar.pojo.Customers;
import cn.accp.pigcar.service.CustService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CustServiceImpl implements CustService {
	
	@Resource
	private CustDao custDao;


	@Override
	public Customers saveCust(Customers cust) {

		int n = custDao.saveCust(cust);

		System.out.println("n="+n+",添加");

		return cust;
	}


	@Override
	public List<Customers> getAllCust(Customers cust) {

		List<Customers> allCust = custDao.getAllCust(cust);

		return allCust;
	}


	@Override
	public List<Customers> getAllCustByPage(Map<String, Object> map) {

		List<Customers> allCustByPage = custDao.getAllCustByPage(map);

		return allCustByPage;
	}


	@Override
	public String deleteCust(String identity) {

		int n = custDao.deleteCust(identity);

		System.out.println("n="+n+",删除");

		return identity;
	}


	@Override
	public Customers findOne(String identity) {

		Customers findOne = custDao.findOne(identity);

		return findOne;
	}


	@Override
	public Customers updateCust(Customers cust) {

		int n = custDao.updateCust(cust);

		System.out.println("n="+n+",修改");

		return cust;
	}






	@Override
	public List<Customers> findOne1(String identity) {

		List<Customers> findOne1 = custDao.findOne1(identity);

		if(findOne1.size()<=1){

			return findOne1;

		}else{

			System.out.println("该id有两个,数据库错误！");

		}

		return null;
	}


	@Override
	public List<Customers> getAllCustByPage2(Map<String, Object> map) {
		// TODO Auto-generated method stub

		List<Customers> allCustByPage2 = custDao.getAllCustByPage2(map);

		return allCustByPage2;

	}
}







