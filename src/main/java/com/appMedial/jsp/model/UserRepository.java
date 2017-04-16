package com.appMedial.jsp.model;

import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findAll();
	
	User findByfirstName(String firstName);
	
	User findByEmail(String email);
}
