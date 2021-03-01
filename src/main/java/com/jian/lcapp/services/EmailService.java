package com.jian.lcapp.services;

import com.jian.lcapp.dto.EmailDTO;
import com.jian.lcapp.dto.CalculationDTO;

public interface EmailService {

	void sendEmail(CalculationDTO calculationDTO, EmailDTO emailDTO, String calculateResult);
}

