package cn.accp.pigcar.service;

import cn.accp.pigcar.pojo.Cars;
import cn.accp.pigcar.util.PageBean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface CarService {

	int addCar(Cars car);


	List<Cars> getAllCars(Map<String, Object> map);
	

	List<Cars> getPageLikeCars(Map<String, Object> map);


	Cars getOneCar(String carNumber);
	

	int updateCar(Cars car);
	

	int deleteOne(Cars car);
	

	String uploadImg(MultipartFile file,String path);
	

	PageBean getPageCar(String sindex, String sSize, Cars car);

	List<Cars> findAllCars();
}
