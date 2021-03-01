package com.jian.lcapp.dao;

import com.jian.lcapp.dto.LoginDTO;
import com.jian.lcapp.model.User;

public interface UserDAO {

	void save(User user);
	boolean exist(String email);
	boolean match(LoginDTO loginDTO);
}
