package cn.accp.pigcar.pojo;

import java.util.Date;

/*
 * flag值说明：
 * 添加添加用户1
 * 修改用户2
 * 用戶修改密碼3
 * 删除用户4
 * 添加汽车10
 * 修改汽车11
 * 删除汽车12
 * 添加客户20
 * 修改客户21
 * 删除客户22
 * 生成出租30
 * 修改检查单31
 * 删除检查单32
 * 修改出租单33
 * 添加角色40
 * 修改角色41
 * 删除角色42
 */
public class Logs implements java.io.Serializable {


	private int start;
	private int end;
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

	private Long id;
	private String username;
	private String action;
	private Date actiontime;
	private Long flag;




	public Logs() {
	}

	public Logs(Long id, String username, String action, Date actiontime,
			Long flag) {
		this.id = id;
		this.username = username;
		this.action = action;
		this.actiontime = actiontime;
		this.flag = flag;
	}
	public Logs(String username, String action, Date actiontime,
			Long flag) {
		this.username = username;
		this.action = action;
		this.actiontime = actiontime;
		this.flag = flag;
	}



	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getActiontime() {
		return this.actiontime;
	}

	public void setActiontime(Date actiontime) {
		this.actiontime = actiontime;
	}

	public Long getFlag() {
		return this.flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

}