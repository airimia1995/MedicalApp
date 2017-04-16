package com.appMedial.jsp.bussines;


import java.util.List;

import com.appMedial.jsp.model.User;



public interface UserService {
	User findById(int id);
	
	public User save(User user);
	
	User findByfirstName(String username);
	

	
	User findByEmail(String email);
}
