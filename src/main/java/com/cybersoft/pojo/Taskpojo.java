package com.cybersoft.pojo;

import java.sql.Date;

public class Taskpojo {
	private long id_task;
	private String name_task;
	private String description_task;
	private String startdate;
	private String enddate;
	private long account_id;
	private long status_id;
	private long project_id;

	public long getId_task() {
		return id_task;
	}

	public void setId_task(long id_task) {
		this.id_task = id_task;
	}

	public String getName_task() {
		return name_task;
	}

	public void setName_task(String name_task) {
		this.name_task = name_task;
	}

	public String getDescription_task() {
		return description_task;
	}

	public void setDescription_task(String description_task) {
		this.description_task = description_task;
	}

	

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}

	public long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(long status_id) {
		this.status_id = status_id;
	}

	public long getProject_id() {
		return project_id;
	}

	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}

}
