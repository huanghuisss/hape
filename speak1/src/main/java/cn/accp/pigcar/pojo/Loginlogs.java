package cn.accp.pigcar.pojo;

import java.util.Date;


public class Loginlogs implements java.io.Serializable {


	private int start;
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	private int end;
	private Long loginlogid;
	private String loginname;
	private String loginip;
	private Date logintime;

	public Loginlogs() {
	}


	public Loginlogs(Long loginlogid) {
		this.loginlogid = loginlogid;
	}

	public Loginlogs(Long loginlogid, String loginname, String loginip,
			Date logintime) {
		this.loginlogid = loginlogid;
		this.loginname = loginname;
		this.loginip = loginip;
		this.logintime = logintime;
	}


	public Long getLoginlogid() {
		return this.loginlogid;
	}

	public void setLoginlogid(Long loginlogid) {
		this.loginlogid = loginlogid;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginip() {
		return this.loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public Date getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

}