package com.appMedial.jsp.bussines;

import java.util.List;

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
	@Override
	public List<Medicament> findAll() {
		// TODO Auto-generated method stub
		return medicamentRepository.findAll();
	}
	@Override
	public Medicament findById(int id) {
		// TODO Auto-generated method stub
		return medicamentRepository.findOne(id);
	}
	@Override
	public Medicament save(Medicament m) {
		// TODO Auto-generated method stub
		return medicamentRepository.save(m);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		 medicamentRepository.delete(id);
	}

}
