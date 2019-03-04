package cn.accp.pigcar.pojo;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {
	private List result;
	private int currentPage;
	private int totalPage;
	private int totalNumber;
	private int pageNumber;
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
