package com.jian.lcapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jian.lcapp.dao.UserDAO;
import com.jian.lcapp.dto.LoginDTO;
import com.jian.lcapp.dto.CalculationDTO;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;

	@ModelAttribute("loginInfo")
	public LoginDTO loginDTO() {
		return new LoginDTO();
	}
	
	@ModelAttribute("calculationInfo")
	public CalculationDTO getUserDTO() {
		
		return new CalculationDTO();
	}
	
	@RequestMapping("/")
	public String login(@ModelAttribute("loginInfo") LoginDTO loginDTO) {
		
		return "login";
	}
	
	@PostMapping("/calculate")
	public String loginSuccess(@Valid @ModelAttribute("loginInfo") LoginDTO loginDTO, BindingResult result, Model model, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "login";
		}
		
		if(!userDAO.match(loginDTO)) {
			model.addAttribute("dismatch", "email and password doesn't match");
			return "login";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("emailId", loginDTO.getEmail());
		
		
		return "calculate";
	}
}
