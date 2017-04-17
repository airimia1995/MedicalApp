package com.appMedial.jsp.bussines;

import java.util.List;

import com.appMedial.jsp.model.Medic;
import com.appMedial.jsp.model.Pacient;
import com.appMedial.jsp.model.User;

public interface PacientService {

	public List<Pacient> findAllByMedic(Medic medic);
	
	public Pacient save(Pacient pacient);
}
