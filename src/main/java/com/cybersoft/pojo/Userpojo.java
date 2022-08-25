package com.cybersoft.pojo;

public class Userpojo {
	private long id;
	private String fullname;
	private String email;
	private String password;
	private String address;
	private String phone;
	private long role_id;
	

	public Userpojo(long id, String fullname, String email, String password, String address, String phone,
			long role_id) {
		
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.role_id = role_id;
	}
	
	
	public Userpojo() {
		
	}
	
	
	

	public Userpojo(long id, String fullname, String email, String address, String phone, long role_id) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.role_id = role_id;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getRole_id() {
		return role_id;
	}

	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

}
