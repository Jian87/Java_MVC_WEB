package com.jian.lcapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jian.lcapp.dto.CalculationDTO;

public class CalculationRowMapper implements RowMapper<CalculationDTO>{

	@Override
	public CalculationDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CalculationDTO calculationDTO = new CalculationDTO();
		
		calculationDTO.setId(rs.getInt("id"));
		calculationDTO.setUsername(rs.getString("username"));
		calculationDTO.setCrushname(rs.getString("crushname"));
		
		return calculationDTO;
	}

}
