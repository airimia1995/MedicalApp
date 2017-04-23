package com.appMedial.jsp.bussines;

import java.util.List;

import org.springframework.stereotype.Component;

import com.appMedial.jsp.model.Pacient;
import com.appMedial.jsp.model.Reteta;

@Component
public interface RetetaService {
	public Reteta save(Reteta reteta);
	public Reteta findByName(String name);
	
}
