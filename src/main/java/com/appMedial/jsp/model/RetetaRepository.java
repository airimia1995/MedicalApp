package com.appMedial.jsp.model;

import org.springframework.data.repository.CrudRepository;

public interface RetetaRepository extends CrudRepository<Reteta,Integer>  {

	Reteta findByBoala(String boala);
}
