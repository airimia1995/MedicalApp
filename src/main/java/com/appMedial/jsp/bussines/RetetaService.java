package com.appMedial.jsp.bussines;

import org.springframework.stereotype.Component;

import com.appMedial.jsp.model.Reteta;

@Component
public interface RetetaService {
	public Reteta save(Reteta reteta);
}
