package com.appMedial.jsp.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appMedial.jsp.model.Medicament;
import com.appMedial.jsp.model.MedicamentRepository;

@Component
public class MedicamentServiceImpl implements MedicamentService {
	
	@Autowired
	private MedicamentRepository medicamentRepository; 
	@Override
	public Medicament findByNume(String nume) {
		// TODO Auto-generated method stub
		return medicamentRepository.findByNume(nume);
	}

}
