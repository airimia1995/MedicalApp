package com.appMedial.jsp.model;

import org.springframework.data.repository.CrudRepository;

public interface MedicRepository extends CrudRepository<Medic,Integer> {
	Medic findByUser(User user);
	
	
	
}
