package cn.accp.pigcar.service.impl;


import cn.accp.pigcar.dao.CheckTableDao;
import cn.accp.pigcar.pojo.Checktable;
import cn.accp.pigcar.pojo.Users;
import cn.accp.pigcar.service.CheckTableService;
import cn.accp.pigcar.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckTableServiceImpl implements CheckTableService {
	@Resource
	private CheckTableDao checkDao;
	@Override
	public List<Checktable> findCheckTableByIf(Checktable check) {
		List<Checktable> listCheck = checkDao.selectCheckByIf(check);
		
		return listCheck;
	}
	@Override
	public Checktable findCheckTableById(Long checkid) {
		Checktable ct =  new Checktable();
		ct.setCheckid(checkid);
		Checktable check = checkDao.selectCheckByPrimaryKey(ct);
		return check;
	}
	@Override
	public boolean updateCheckTable(Checktable check) {
		int x = checkDao.updateCheckTable(check);
		if (x>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteCheckTable(Long checkid) {
		Checktable ct = new Checktable();
		ct.setCheckid(checkid);
		int x = checkDao.deleteCheckTableById(ct);
		if (x>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean addCheckTable(Checktable checktable) {
		int x = checkDao.insertCheckTable(checktable);
		if (x>0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Checktable> findCheckByIf(Checktable checktable, PageBean<Checktable> page) {

		Map<String, Object> map = new HashMap<String,Object>();
		int start = page.getStartRow();
		int end = page.getEndRow();
		map.put("start", start);
		map.put("end", end);
		map.put("checktable",checktable);
		checktable.setStart(page.getStartRow());
		checktable.setEnd(page.getEndRow());
		List<Checktable> checkList = checkDao.selectCheckByIfForPage(map);
		return checkList;
	}

}
