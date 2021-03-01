package com.jian.lcapp.dto;

import javax.validation.constraints.NotEmpty;

public class CalculationDTO {
	
	
	private int id;
	
	@NotEmpty(message = "{calculate.username.empty}")
	private String username;
	
	@NotEmpty(message = "{calculate.crushname.empty}")
	private String crushname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCrushname() {
		return crushname;
	}
	public void setCrushname(String crushname) {
		this.crushname = crushname;
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", crushname=" + crushname + "]";
	}
	
	
}
