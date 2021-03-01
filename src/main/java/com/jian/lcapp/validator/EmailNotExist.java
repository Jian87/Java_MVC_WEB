package com.jian.lcapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.jian.lcapp.dao.UserDAOImpl;

public class EmailNotExist implements ConstraintValidator<NotExist, String> {

	@Autowired
	private UserDAOImpl userDao;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if(userDao.exist(email)) {
			return true;
		}
		
		return false;
	}

}
