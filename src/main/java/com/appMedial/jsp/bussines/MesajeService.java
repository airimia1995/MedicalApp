package com.appMedial.jsp.bussines;

import java.util.List;

import com.appMedial.jsp.model.Mesaje;
import com.appMedial.jsp.model.Pacient;

public interface MesajeService {
	List<Mesaje> findByReceiver_idAndSender_id(String recid, String sendid);
	public Mesaje save(Mesaje mesaje);
}
