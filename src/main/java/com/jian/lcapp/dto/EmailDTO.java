package com.jian.lcapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO {

	@Email(message = "{email.valid}")
	@NotEmpty(message = "{email.empty}")
	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
