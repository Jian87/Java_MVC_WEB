package com.jian.lcapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jian.lcapp.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		if(rs == null) {
			return null;
		}
		
		User user = new User();
		
		user.setFirstName(rs.getString("firstname"));
		user.setLastName(rs.getString("lastname"));
		user.setEmailId(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setGender(rs.getString("gender"));
		
		return user;
	}

	
	
}
