package com.jian.lcapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jian.lcapp.dao.UserDAOImpl;
import com.jian.lcapp.dto.CalculationDTO;
import com.jian.lcapp.dto.SignDTO;
import com.jian.lcapp.model.User;

@Controller
public class SigninController {
	
	@Autowired
	private UserDAOImpl userDAO;

	@ModelAttribute("calculationInfo")
	public CalculationDTO getUserDTO() {
		
		return new CalculationDTO();
	}
	
	@ModelAttribute("signinInfo")
	public SignDTO signDTO() {
		return new SignDTO();
	}
	
	@GetMapping("/signin-page")
	public String signin(@ModelAttribute("signinInfo") SignDTO signDTO) {
		
		return "signin";
	}
	
	@PostMapping("/signin-success")
	public String signinSuccess(@Valid @ModelAttribute("signinInfo") SignDTO signDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			return "signin";
		}
		
		User user = new User();
		user.setFirstName(signDTO.getFirstName());
		user.setLastName(signDTO.getLastName());
		user.setPassword(signDTO.getPassword());
		user.setEmailId(signDTO.getEmail());
		user.setGender(signDTO.getGender());
		
		userDAO.save(user);
		
		return "calculate";
		
	}
}
