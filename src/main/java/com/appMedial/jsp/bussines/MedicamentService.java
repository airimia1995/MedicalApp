package com.appMedial.jsp.bussines;

import java.util.List;

import com.appMedial.jsp.model.Medicament;

public interface MedicamentService {
	Medicament findByNume(String nume);
	List<Medicament> findAll();
	Medicament findById(int id);
	Medicament save(Medicament m);
	public void delete(int id);
}
