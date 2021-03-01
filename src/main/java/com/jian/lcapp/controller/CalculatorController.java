package com.jian.lcapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jian.lcapp.dao.CalculationDAO;
import com.jian.lcapp.dto.CalculationDTO;
import com.jian.lcapp.services.CalculateServiceImpl;

@Controller
public class CalculatorController {
	
	@Autowired
	private CalculateServiceImpl calculateService;
	
	@Autowired
	private CalculationDAO calculationDAO;
	
	@GetMapping("/calculate")
	public String calculate(@ModelAttribute("calculationInfo") CalculationDTO calculationDTO) {
		
		return "calculate";
	}
	
	@PostMapping("/calculate-result")
	public String directVisitCalculateResult() {
		return "redirect:/calculate";
	}
	
	@GetMapping("/calculate-result")
	public String calculateResult(@Valid @ModelAttribute("calculationInfo") CalculationDTO calculationDTO, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "calculate";
		}
		
		// create a service to do the calculation and display the result here
		String calculationResult = calculateService.calculateResult(calculationDTO.getUsername(), calculationDTO.getCrushname());
		
		HttpSession session = request.getSession();
		
		CalculationDTO myCalculationDTO = (CalculationDTO) session.getAttribute("calculationInfo");
		
		// when user refresh the calculate result page, don't insert the data into database again and again
		if(myCalculationDTO != null && myCalculationDTO.getUsername().equals(calculationDTO.getUsername()) && myCalculationDTO.getCrushname().equals(calculationDTO.getCrushname())) {
			return "calculate-result";
		}
		
		// create a session to record the calculation info
				
		session.setAttribute("calculationInfo", calculationDTO);
		session.setAttribute("calculationResult", calculationResult);
		
		// save the calculation into the database
		String emailId = (String) session.getAttribute("emailId");
		
		LocalDateTime now = LocalDateTime.now();
		
		
		calculationDAO.save(emailId, calculationDTO, calculationResult, now);
		
		
		return "calculate-result";
	}
	
	@GetMapping("/calculate-history")
	public String getCalculateHistory(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		String emailId = (String) session.getAttribute("emailId");
		
		List<CalculationDTO> historyList = calculationDAO.findAllByEmailId(emailId);
		
		model.addAttribute("historyList", historyList);
		
		return "calculation-history";
	}
	
	@GetMapping("/deleteCalculationRecord")
	public String deleteCalculationRecord(@RequestParam("recordId") int recordId) {
		
		calculationDAO.deleteRecordById(recordId);
		
		return "redirect:/calculate-history";
	}
}
