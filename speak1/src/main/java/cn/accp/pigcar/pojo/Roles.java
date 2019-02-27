package cn.accp.pigcar.pojo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Roles implements java.io.Serializable {



	private Long roleid;
	private String rolename;
	private List<Menus> menuses = new ArrayList<Menus>();
	private Set<Users> userses = new HashSet<Users>();

	public Roles(Long roleid, String rolename, List<Menus> menuses,
				 Set<Users> userses) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.menuses = menuses;
		this.userses = userses;
	}

	public List<Menus> getMenuses() {
		return menuses;
	}

	public void setMenuses(List<Menus> menuses) {
		this.menuses = menuses;
	}

	@Override
	public String toString() {
		return "Roles [roleid=" + roleid + ", rolename=" + rolename
				+ ", menuses=" + menuses + ", userses=" + userses + "]";
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<Users> getUserses() {
		return userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	public Roles() {
		super();

	}

}