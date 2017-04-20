package com.appMedial.jsp.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appMedial.jsp.model.RetetaMedicament;
import com.appMedial.jsp.model.RetetaMedicamentRepository;

@Component
public class RetetaMedicamentServiceImpl implements RetetaMedicamentService {
	@Autowired
	private RetetaMedicamentRepository retetaMedicamentRepository;
	@Override
	
	public RetetaMedicament save(RetetaMedicament retetaMedicament) {
		// TODO Auto-generated method stub
		return retetaMedicamentRepository.save(retetaMedicament);
	}

}
