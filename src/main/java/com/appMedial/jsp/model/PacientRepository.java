package com.appMedial.jsp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PacientRepository extends CrudRepository<Pacient, Integer>  {
	List<Pacient> findAllByMedic(Medic medic);
	

}
