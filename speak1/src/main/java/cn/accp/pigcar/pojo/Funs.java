package cn.accp.pigcar.pojo;



public class Funs implements java.io.Serializable {



	private Long funid;
	private Menus menus;
	private String funname;
	private String funurl;
	private Long menuid;

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}


	public Funs() {
	}


	public Funs(Long funid, Menus menus, String funname, String funurl) {
		this.funid = funid;
		this.menus = menus;
		this.funname = funname;
		this.funurl = funurl;
	}

	// Property accessors

	public Long getFunid() {
		return this.funid;
	}

	public void setFunid(Long funid) {
		this.funid = funid;
	}

	public Menus getMenus() {
		return this.menus;
	}

	public void setMenus(Menus menus) {
		this.menus = menus;
	}

	public String getFunname() {
		return this.funname;
	}

	public void setFunname(String funname) {
		this.funname = funname;
	}

	public String getFunurl() {
		return this.funurl;
	}

	public void setFunurl(String funurl) {
		this.funurl = funurl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funid == null) ? 0 : funid.hashCode());
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
		final Funs other = (Funs) obj;
		if (funid == null) {
			if (other.funid != null)
				return false;
		} else if (!funid.equals(other.funid))
			return false;
		return true;
	}

}