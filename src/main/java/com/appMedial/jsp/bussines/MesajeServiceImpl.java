package com.appMedial.jsp.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appMedial.jsp.model.Mesaje;
import com.appMedial.jsp.model.MesajeRepository;
@Component
public  class MesajeServiceImpl implements MesajeService {
	
	@Autowired
	private MesajeRepository mesajeRepository; 
	@Override
	public List<Mesaje> findByReceiver_idAndSender_id(String  recid, String sendid) {
		
	return mesajeRepository.findAllByReceiver_idAndSender_id(recid, sendid);
	
	}
	@Override
	public Mesaje save(Mesaje mesaje) {
		return mesajeRepository.save(mesaje);
	}

}
