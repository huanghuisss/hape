package cn.accp.pigcar.pojo;

import java.util.HashSet;
import java.util.Set;


public class Customers implements java.io.Serializable {

	private String identity;
	private String custname;
	private String sex;
	private String address;
	private String phone;
	private String career;
	private String custpwd;
	
	
	private Set renttables = new HashSet(0);

	public Customers() {
	}


	public Customers(String identity, String custname, String sex,
			String address, String phone, String career, String custpwd) {
		this.identity = identity;
		this.custname = custname;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.career = career;
		this.custpwd = custpwd;
	}


	public Customers(String identity, String custname, String sex,
			String address, String phone, String career, String custpwd,
			Set renttables) {
		this.identity = identity;
		this.custname = custname;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.career = career;
		this.custpwd = custpwd;
		this.renttables = renttables;
	}



	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCareer() {
		return this.career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getCustpwd() {
		return this.custpwd;
	}

	public void setCustpwd(String custpwd) {
		this.custpwd = custpwd;
	}

	public Set getRenttables() {
		return this.renttables;
	}

	public void setRenttables(Set renttables) {
		this.renttables = renttables;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identity == null) ? 0 : identity.hashCode());
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
		final Customers other = (Customers) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customers [identity=" + identity + ", custname=" + custname
				+ ", sex=" + sex + ", address=" + address + ", phone=" + phone
				+ ", career=" + career + ", custpwd=" + custpwd + "]";
	}


	
	

}