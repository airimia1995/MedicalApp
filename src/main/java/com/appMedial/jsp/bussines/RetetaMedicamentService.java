package com.appMedial.jsp.bussines;

import org.springframework.stereotype.Component;

import com.appMedial.jsp.model.RetetaMedicament;

@Component
public interface RetetaMedicamentService {

	public RetetaMedicament save(RetetaMedicament retetaMedicament);
}
