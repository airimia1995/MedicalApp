package com.appMedial.jsp.model;

import org.springframework.data.repository.CrudRepository;

public interface MedicamentRepository  extends CrudRepository<Medicament,Integer> {
	Medicament findByNume(String nume);
}
