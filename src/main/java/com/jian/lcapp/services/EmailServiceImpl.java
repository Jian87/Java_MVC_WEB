package com.jian.lcapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jian.lcapp.dto.EmailDTO;
import com.jian.lcapp.dto.CalculationDTO;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(CalculationDTO calculationDTO, EmailDTO emailDTO, String calculateResult) {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setTo(emailDTO.getEmailId());
		simpleMailMessage.setSubject("Love Calculation Result");
		simpleMailMessage.setText("Hi " + calculationDTO.getUsername() + " The calculation result is: " 
								+ calculateResult  + ". Enjoy your time!");
		
		javaMailSender.send(simpleMailMessage);
	}
}
