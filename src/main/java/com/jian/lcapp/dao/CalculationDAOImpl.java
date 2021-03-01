package com.jian.lcapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jian.lcapp.dto.CalculationDTO;

@Service
public class CalculationDAOImpl implements CalculationDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CalculationDTO> findAll() {
		
		String sql = "select * from calculationhistory";
		
		List<CalculationDTO> historyList = jdbcTemplate.query(sql, new CalculationRowMapper());
		
		return historyList;
	}

	@Override
	public void save(String emailId, CalculationDTO calculationDTO, String calculationResult, LocalDateTime now) {
		
		String sql = "INSERT INTO calculationhistory ( `emailId`, `username`, `crushname`, `calculationresult`, `Date`) VALUES (?,?,?,?,?);";
		
		Object[] params = {emailId, calculationDTO.getUsername(), calculationDTO.getCrushname(), calculationResult, now};
		
		jdbcTemplate.update(sql, params);
				
		
	}

	@Override
	public List<CalculationDTO> findAllByEmailId(String emailId) {
		
		String sql = "select * from calculationhistory where emailId = ?";
		
		List<CalculationDTO> historyList = jdbcTemplate.query(sql, new CalculationRowMapper(), emailId);
		
		return historyList;
	}

	@Override
	public void deleteRecordById(int recordId) {
		
		String sql = "delete from calculationhistory where id = ?";
		
		jdbcTemplate.update(sql, recordId);
		
	}

}
