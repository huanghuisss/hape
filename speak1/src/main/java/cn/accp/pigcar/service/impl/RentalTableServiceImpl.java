package cn.accp.pigcar.service.impl;


import cn.accp.pigcar.dao.RentalTableDao;
import cn.accp.pigcar.pojo.Renttable;
import cn.accp.pigcar.service.RentalTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RentalTableServiceImpl implements RentalTableService {

	@Resource
	private RentalTableDao rentalTableDao;
	@Override
	public List<Renttable> findRentalTableByIf(Renttable renttable) {
		List<Renttable> list = rentalTableDao.selectRentalTableByIf(renttable);
		System.out.println(list);
		return list;
	}
	@Override
	public Renttable findRentalByRenTableId(String tableid) {
		Renttable renttable = new Renttable();
		if (null != tableid && !"".equals(tableid)) {
			renttable.setTableid(Long.parseLong(tableid));
		}else{
			throw new RuntimeException("接收到的tableid为空，不能转换成Long类型！");
		}

		Renttable rt = rentalTableDao.selectRentaalTableByPrimaryKey(renttable);
		return rt;
	}
	@Override
	public boolean updateRentable(Renttable renttable) {

		int x = rentalTableDao.updateRenttable(renttable);
		if (x>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addRentTable(Renttable rent) {
		int x = rentalTableDao.insertRenttable(rent);
		if (x>0) {
			return true;
		}
		return false;
	}



}
