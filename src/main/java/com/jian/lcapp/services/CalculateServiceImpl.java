package com.jian.lcapp.services;

import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

	private final String CAL_STR = "FLAME";
	
	@Override
	public String calculateResult(String username, String crushname) {
		
		int len = username.length() + crushname.length();
		
		int rem = len % CAL_STR.length();
		
		return calculate(CAL_STR.charAt(rem));
		
	}
	
	public String calculate(char ch) {
		
		switch (ch) {
		case 'A':
			return CalculateFormula.FORMULA_A;
		case 'F':
			return CalculateFormula.FORMULA_F;
		case 'L':
			return CalculateFormula.FORMULA_L;
		case 'M':
			return CalculateFormula.FORMULA_M;
		case 'E':
			return CalculateFormula.FORMULA_E;
		default:
			return "";
		}
		
	}

}
