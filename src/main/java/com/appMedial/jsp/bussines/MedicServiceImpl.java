package com.appMedial.jsp.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.appMedial.jsp.model.Medic;
import com.appMedial.jsp.model.MedicRepository;
import com.appMedial.jsp.model.User;


@Component
public class MedicServiceImpl implements MedicService {
	
	@Autowired
	private MedicRepository medicRepository;

	@Override
	public Medic findByUser(User user) {
		// TODO Auto-generated method stub
		return medicRepository.findByUser(user);
	}

	

}
