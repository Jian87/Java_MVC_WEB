package com.jian.lcapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.jian.lcapp.dao.UserDAOImpl;

public class EmailExist implements ConstraintValidator<Exist, String>{

	@Autowired
	private UserDAOImpl userDAO;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if(userDAO.exist(email)) {
			return false;
		}
		
		return true;
	}

	
	
}
