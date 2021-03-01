package com.jian.lcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jian.lcapp.dto.LoginDTO;

@Controller
public class GlobalController {
	
	@ModelAttribute("loginInfo")
	public LoginDTO loginDTO() {
		return new LoginDTO();
	}

	@GetMapping("/logout")
	public String logout() {
		
		return "redirect:/";
	}
}
