package com.appMedial.jsp.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appMedial.jsp.model.Pacient;
import com.appMedial.jsp.model.User;
import com.appMedial.jsp.model.UserRepository;


@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;



	@Override
	public User save(User user) {
		user.setProfile("pacient");

		return userRepository.save(user);
	}

	@Override
	public User findByfirstName(String username) {
		
		return userRepository.findByfirstName(username);
	}
	
	@Override
	public User findByEmail(String email){
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findAllByPacient(List<Pacient> pacienti) {
		// TODO Auto-generated method stub
		return userRepository.findAllByPacient(pacienti);
	}

	@Override
	public User findByPacient(Pacient pacient) {
		// TODO Auto-generated method stub
		return userRepository.findByPacient(pacient);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	

	
}
