package com.cybersoft.pojo;

import java.sql.Date;

public class Projectpojo {
	private long id;
	private String name_project;
	private String description_project;
	private String startdate;
	private String enddate;
	private long account_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName_project() {
		return name_project;
	}

	public void setName_project(String name_project) {
		this.name_project = name_project;
	}

	public String getDescription_project() {
		return description_project;
	}

	public void setDescription_project(String description_project) {
		this.description_project = description_project;
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

}
