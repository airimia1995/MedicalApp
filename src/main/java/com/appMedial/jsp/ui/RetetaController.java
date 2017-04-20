package com.appMedial.jsp.ui;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.appMedial.jsp.bussines.MedicService;
import com.appMedial.jsp.bussines.MedicamentService;
import com.appMedial.jsp.bussines.PacientService;
import com.appMedial.jsp.bussines.RetetaService;
import com.appMedial.jsp.bussines.UserService;
import com.appMedial.jsp.model.Medic;
import com.appMedial.jsp.model.Medicament;
import com.appMedial.jsp.model.Pacient;
import com.appMedial.jsp.model.Reteta;
import com.appMedial.jsp.model.User;

@Controller
public class RetetaController {
	@Autowired
	private UserService userService;
	@Autowired
	private PacientService pacientService;
	@Autowired
	private MedicService medicService;
	@Autowired
	private MedicamentService medicamentService;
	@Autowired
	private RetetaService retetaService;
	
	
	@RequestMapping(value = "/reteta-{user_email}-pacient", method = RequestMethod.POST)
	public String addReteta(@ModelAttribute("reteta") @Valid Reteta reteta,@PathVariable String user_email, ModelMap model){
		User user_pacient = userService.findByEmail(user_email);
		Pacient p = pacientService.findByUser(user_pacient);
		reteta.setPacient(p);
		
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    User user = userService.findByEmail(name);
	    Medic m = medicService.findByUser(user);
		
	    reteta.setMedic(m);
	    retetaService.save(reteta);
		
	
		return "reteta";
	}
	
	@RequestMapping(value="/reteta-{boala}",  method = RequestMethod.GET)
	public String addMedicamente(@PathVariable String boala, ModelMap model){
		return "medicamenteReteta";
		
	}
	
}
