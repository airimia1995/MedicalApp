package com.appMedial.jsp.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appMedial.jsp.model.Medic;
import com.appMedial.jsp.model.Pacient;
import com.appMedial.jsp.model.PacientRepository;
import com.appMedial.jsp.model.User;

@Component
public class PacientServiceImpl implements PacientService {
	@Autowired
	private PacientRepository pacientRepository;
		
	@Override
	public Pacient save(Pacient pacient) {
		// TODO Auto-generated method stub
		return pacientRepository.save(pacient);
	}

	@Override
	public List<Pacient> findAllByMedic(Medic medic) {
		// TODO Auto-generated method stub
		return pacientRepository.findAllByMedic(medic);
	}

	@Override
	public Pacient findByUser(User u) {
		// TODO Auto-generated method stub
		return pacientRepository.findByUser(u);
	}

	@Override
	public Pacient create(Pacient pacient) {
		// TODO Auto-generated method stub
		return pacientRepository.save(pacient);
	}

}
