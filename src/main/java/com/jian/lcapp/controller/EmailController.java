package com.jian.lcapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jian.lcapp.dto.EmailDTO;
import com.jian.lcapp.dto.CalculationDTO;
import com.jian.lcapp.services.EmailServiceImpl;

@Controller
public class EmailController {

	@Autowired
	private EmailServiceImpl emailService;

	@ModelAttribute("emailInfo")
	public EmailDTO getEmailDTO() {

		return new EmailDTO();
	}

	@GetMapping("/email-process")
	public String processEmail(@ModelAttribute("emailInfo") EmailDTO emailDTO) {
		
		return "email-process";
	}

	@PostMapping("/email-send")
	public String sendEmail(@Valid @ModelAttribute("emailInfo") EmailDTO emailDTO, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "email-process";
		}

		HttpSession session = request.getSession();

		CalculationDTO calculationDTO = (CalculationDTO) session.getAttribute("calculationInfo");
		String calculateResult =(String) session.getAttribute("calculateResult");

		emailService.sendEmail(calculationDTO, emailDTO, calculateResult);

		return "email-send";
	}
}
