package cn.accp.pigcar.pojo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menus implements java.io.Serializable {



	private Long menuid;
	@Override
	public String toString() {
		return "Menus [menuid=" + menuid + ", menuname=" + menuname
				+ ", connurl=" + connurl + ", fatherid=" + fatherid
				+ ", funses=" + funses + ", roleses=" + roleses + ", roleList="
				+ roleList + ", isChecked=" + isChecked + ", menus=" + menuList
				+ "]";
	}

	private String menuname;
	private String connurl;
	private Long fatherid;
	private Set funses = new HashSet(0);
	private Set roleses = new HashSet(0);
	private List<Roles> roleList = new ArrayList<Roles>();//角色  菜单表
	private String isChecked;
	private List<Menus> menuList=new ArrayList<Menus>();
	// Constructors


	public String getIsChecked() {
		return isChecked;
	}

	public List<Roles> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Roles> roleList) {
		this.roleList = roleList;
	}

	public List<Menus> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menus> menuList) {
		this.menuList = menuList;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}


	public Menus() {
	}


	public Menus(Long menuid, String menuname, Long fatherid) {
		this.menuid = menuid;
		this.menuname = menuname;
		this.fatherid = fatherid;
	}


	public Menus(Long menuid, String menuname, String connurl, Long fatherid,
				 Set funses, Set roleses) {
		this.menuid = menuid;
		this.menuname = menuname;
		this.connurl = connurl;
		this.fatherid = fatherid;
		this.funses = funses;
		this.roleses = roleses;
	}

	// Property accessors

	public Long getMenuid() {
		return this.menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getConnurl() {
		return this.connurl;
	}

	public void setConnurl(String connurl) {
		this.connurl = connurl;
	}

	public Long getFatherid() {
		return this.fatherid;
	}

	public void setFatherid(Long fatherid) {
		this.fatherid = fatherid;
	}

	public Set getFunses() {
		return this.funses;
	}

	public void setFunses(Set funses) {
		this.funses = funses;
	}

	public Set getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set roleses) {
		this.roleses = roleses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuid == null) ? 0 : menuid.hashCode());
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
		final Menus other = (Menus) obj;
		if (menuid == null) {
			if (other.menuid != null)
				return false;
		} else if (!menuid.equals(other.menuid))
			return false;
		return true;
	}

}