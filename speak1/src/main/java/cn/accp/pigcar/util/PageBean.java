package cn.accp.pigcar.util;

import java.util.List;

public class PageBean<T> {
	private int size = 10;//每页显示记录     //ok
	private int index = 1;// 当前页号       ok       
	private int totalPageCount = 1;// 总页数     ok
	private int totalCount = 0;// 记录总数    //ok             2
	
	
	private int[] numbers;//展示页数集合 
	protected List<T> list;//要显示到页面的数据集   

	/**
	 * 得到开始记录
	 */
	public int getStartRow() {

		return (index - 1) * size;
	}

	/**
	 * 得到结束记录
	 */
	public int getEndRow() {
		
		return index * size;
	}

	public int getSize() {		
		return size;
	}

	public void setSize(int size) {
		if (size > 0) {
			this.size = size;
		}
	}
	public int getIndex() {
		if (totalPageCount == 0) {
			
			return 0;
		}
		
		return index;
	}

	public void setIndex(int index) {
	
		if (index > 0) {
			
			this.index = index;
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount >= 0) {
			this.totalCount = totalCount;
			setTotalPageCountByRs();//根据总记录数计算总页
		}
	}

	
	public int getTotalPageCount() {
		return this.totalPageCount;
	}

	private void setTotalPageCountByRs() {
		if (this.size > 0 && this.totalCount > 0 && this.totalCount % this.size == 0) {
			this.totalPageCount = this.totalCount / this.size;
		} else if (this.size > 0 && this.totalCount > 0 && this.totalCount % this.size > 0) {
			this.totalPageCount = (this.totalCount / this.size) + 1;
		} else {
			this.totalPageCount = 0;
		}
		setNumbers(totalPageCount);//获取展示页数集合
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int totalPageCount) {
		if(totalPageCount>0){
			//!.当前数组的长度
			int[] numbers = new int[totalPageCount>10?10:totalPageCount];//页面要显示的页数集合
			int k =0;
			for(int i = 0;i < totalPageCount;i++){
				//保证当前页为集合的中
				if((i>=index- (numbers.length/2+1) || i >= totalPageCount-numbers.length) && k<numbers.length){
					numbers[k] = i+1;
					k++;
				}else if(k>=numbers.length){
					break;
				}				
			}
			
			this.numbers = numbers;
		}
		
	}
	
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
