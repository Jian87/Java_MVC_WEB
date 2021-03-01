package com.jian.lcapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jian.lcapp.dto.LoginDTO;
import com.jian.lcapp.model.User;
import com.jian.lcapp.rowmapper.UserRowMapper;

@Service
public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(User user) {
		
		String sql = "insert into userinfo values(?, ?, ?, ?, ?)";

		Object[] userArgs = {user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmailId(), user.getGender()};
		
		jdbcTemplate.update(sql, userArgs);
		
		System.out.println("1 user info is inserted into database");
	}

	public boolean exist(String email) {
		
		String sql = "select * from userinfo where email = ?";
		
		List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), email);
		
		return users.size() != 0;
	
	}

	@Override
	public boolean match(LoginDTO loginDTO) {
		
		String sql = "select * from userinfo where email = ? and password = ?";
		
		List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), loginDTO.getEmail(), loginDTO.getPassword());
		
		return users.size() == 1;
	}

}
