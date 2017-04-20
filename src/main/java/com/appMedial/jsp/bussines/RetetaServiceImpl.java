package com.appMedial.jsp.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appMedial.jsp.model.Reteta;
import com.appMedial.jsp.model.RetetaRepository;

@Component
public class RetetaServiceImpl implements RetetaService {
	@Autowired
	private RetetaRepository retetaRepository;
	
	@Override
	public Reteta save(Reteta reteta) {
		// TODO Auto-generated method stub
		return retetaRepository.save(reteta);
	}

}
