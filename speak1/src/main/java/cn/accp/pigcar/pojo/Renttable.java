package cn.accp.pigcar.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Renttable implements java.io.Serializable {


	//每辆汽车的销售总量
	private Long countPrice;
	//每辆车被租的次数
	private Long carrentcount;
	
	public Long getCountPrice() {
		return countPrice;
	}

	public void setCountPrice(Long countPrice) {
		this.countPrice = countPrice;
	}

	public Long getCarrentcount() {
		return carrentcount;
	}

	public void setCarrentcount(Long carrentcount) {
		this.carrentcount = carrentcount;
	}

	private String custid;
	private String carid;
	private String userid;
	private Long tableid;

	public Integer getStrat() {
		return strat;
	}

	public void setStrat(Integer strat) {
		this.strat = strat;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	private Integer strat;
	private Integer end;
	private Users users;
	private Cars cars;
	private Customers customers;
	
	private Double imprest;
	private Double shouldpayprice;
	private Double price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date begindate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date shouldreturndate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date returndate;
	private Long rentflag;
	private Set checktables = new HashSet(0);


	public Renttable() {
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Renttable [custid=" + custid + ", carid=" + carid + ", userid="
				+ userid + ", tableid=" + tableid + ", users=" + users
				+ ", cars=" + cars + ", customers=" + customers + ", imprest="
				+ imprest + ", shouldpayprice=" + shouldpayprice + ", price="
				+ price + ", begindate=" + begindate + ", shouldreturndate="
				+ shouldreturndate + ", returndate=" + returndate
				+ ", rentflag=" + rentflag + ", checktables=" + checktables
				+ "]";
	}


	public Renttable(Long tableid, Users users, Cars cars, Customers customers,
			Double imprest, Double shouldpayprice, Double price,
			Date begindate, Date shouldreturndate, Long rentflag) {
		this.tableid = tableid;
		this.users = users;
		this.cars = cars;
		this.customers = customers;
		this.imprest = imprest;
		this.shouldpayprice = shouldpayprice;
		this.price = price;
		this.begindate = begindate;
		this.shouldreturndate = shouldreturndate;
		this.rentflag = rentflag;
	}

	public Renttable(Long tableid, Users users, Cars cars, Customers customers,
			Double imprest, Double shouldpayprice, Double price,
			Date begindate, Date shouldreturndate, Date returndate,
			Long rentflag, Set checktables) {
		this.tableid = tableid;
		this.users = users;
		this.cars = cars;
		this.customers = customers;
		this.imprest = imprest;
		this.shouldpayprice = shouldpayprice;
		this.price = price;
		this.begindate = begindate;
		this.shouldreturndate = shouldreturndate;
		this.returndate = returndate;
		this.rentflag = rentflag;
		this.checktables = checktables;
	}


	public Long getTableid() {
		return this.tableid;
	}

	public void setTableid(Long tableid) {
		this.tableid = tableid;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Cars getCars() {
		return this.cars;
	}

	public void setCars(Cars cars) {
		this.cars = cars;
	}

	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Double getImprest() {
		return this.imprest;
	}

	public void setImprest(Double imprest) {
		this.imprest = imprest;
	}

	public Double getShouldpayprice() {
		return this.shouldpayprice;
	}

	public void setShouldpayprice(Double shouldpayprice) {
		this.shouldpayprice = shouldpayprice;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getShouldreturndate() {
		return this.shouldreturndate;
	}

	public void setShouldreturndate(Date shouldreturndate) {
		this.shouldreturndate = shouldreturndate;
	}

	public Date getReturndate() {
		return this.returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public Long getRentflag() {
		return this.rentflag;
	}

	public void setRentflag(Long rentflag) {
		this.rentflag = rentflag;
	}

	public Set getChecktables() {
		return this.checktables;
	}

	public void setChecktables(Set checktables) {
		this.checktables = checktables;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tableid == null) ? 0 : tableid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Renttable other = (Renttable) obj;
		if (tableid == null) {
			if (other.tableid != null)
				return false;
		} else if (!tableid.equals(other.tableid))
			return false;
		return true;
	}

}