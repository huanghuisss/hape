package cn.accp.pigcar.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Checktable entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Checktable implements java.io.Serializable {



	private Long checkid;
	private Renttable renttable;
	private Users users;
	private Integer start;
	private Integer end;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date checkdate;
	private String field;
	private String problem;
	private Double paying;
	private Long tableid;
	private String checkUserId;


	public String getCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(String checkUserId) {
		this.checkUserId = checkUserId;
	}

	public Long getTableid() {
		return tableid;
	}

	public void setTableid(Long tableid) {
		this.tableid = tableid;
	}


	public Checktable() {
	}

	public Checktable(Long checkid, Renttable renttable, Users users,
			Date checkdate) {
		this.checkid = checkid;
		this.renttable = renttable;
		this.users = users;
		this.checkdate = checkdate;
	}

	public Checktable(Long checkid, Renttable renttable, Users users,
			Date checkdate, String field, String problem, Double paying) {
		this.checkid = checkid;
		this.renttable = renttable;
		this.users = users;
		this.checkdate = checkdate;
		this.field = field;
		this.problem = problem;
		this.paying = paying;
	}


	public Long getCheckid() {
		return this.checkid;
	}

	public void setCheckid(Long checkid) {
		this.checkid = checkid;
	}

	public Renttable getRenttable() {
		return this.renttable;
	}

	public void setRenttable(Renttable renttable) {
		this.renttable = renttable;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getCheckdate() {
		return this.checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getProblem() {
		return this.problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Double getPaying() {
		return this.paying;
	}

	public void setPaying(Double paying) {
		this.paying = paying;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkid == null) ? 0 : checkid.hashCode());
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
		final Checktable other = (Checktable) obj;
		if (checkid == null) {
			if (other.checkid != null)
				return false;
		} else if (!checkid.equals(other.checkid))
			return false;
		return true;
	}

}