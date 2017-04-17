package com.appMedial.jsp.bussines;

import com.appMedial.jsp.model.Medic;
import com.appMedial.jsp.model.User;

public interface MedicService {
	Medic findByUser(User user);
}
