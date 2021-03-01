package com.jian.lcapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.jian.lcapp.dto.CalculationDTO;

public interface CalculationDAO {

	List<CalculationDTO> findAll();

	void save(String emailId, CalculationDTO calculationDTO, String calculationResult, LocalDateTime now);
	
	List<CalculationDTO> findAllByEmailId(String emailId);

	void deleteRecordById(int recordId);
}
