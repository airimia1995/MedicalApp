package com.appMedial.jsp.bussines;


import java.util.List;

import com.appMedial.jsp.model.Pacient;
import com.appMedial.jsp.model.User;



public interface UserService {

	
	public User save(User user);
	
	User findByfirstName(String username);
	
	List<User> findAllByPacient(List<Pacient> pacienti);
	
	User findByEmail(String email);
	
	User findByPacient(Pacient pacient);
	
	List<User> findAll();
}
