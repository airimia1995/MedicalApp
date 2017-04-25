package com.appMedial.jsp.ui;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appMedial.jsp.bussines.MedicService;
import com.appMedial.jsp.bussines.PacientService;
import com.appMedial.jsp.bussines.RetetaService;
import com.appMedial.jsp.bussines.UserService;
import com.appMedial.jsp.model.Medicament;
import com.appMedial.jsp.model.Pacient;
import com.appMedial.jsp.model.Reteta;
import com.appMedial.jsp.model.User;

@Controller
public class PacientRetetaControler {
	@Autowired
	private UserService userService;
	@Autowired
	private PacientService pacientService;
	@Autowired
	private MedicService medicService;
	@Autowired
	private RetetaService retetaService;
	
	@RequestMapping(value ={ "/viewRecipes"},method = RequestMethod.GET)
	public String  afisare(ModelMap model){
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
	      User user = userService.findByEmail(name);
	      Pacient pacient = pacientService.findByUser(user);
	      
	      Set<Reteta> retete = pacient.getReteta();
	      model.addAttribute("retete",retete);
		return "viewRecipes1";
	}
	
	@RequestMapping(value="/viewRecipes-{boala}",  method = RequestMethod.GET)
	public String reteta(@PathVariable String boala, ModelMap model){
		Reteta reteta = retetaService.findByName(boala);
		Set<Medicament> medicamente = reteta.getMedicamentList();
		model.addAttribute("medicamente", medicamente);
		return "viewRecipe-drugs1";
	}

}
