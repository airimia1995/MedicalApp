package com.appMedial.jsp.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appMedial.jsp.model.Pacient;
import com.appMedial.jsp.model.PacientRepository;

@Component
public class PacientServiceImpl implements PacientService {
	@Autowired
	private PacientRepository pacientRepository;
		
	@Override
	public Pacient save(Pacient pacient) {
		// TODO Auto-generated method stub
		return pacientRepository.save(pacient);
	}

}
