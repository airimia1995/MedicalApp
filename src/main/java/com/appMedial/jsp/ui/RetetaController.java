package com.appMedial.jsp.ui;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/retetaM-{boala}")
	public String addMedicamente( ModelMap model){
//		List<Medicament> medicamente = medicamentService.findAllByNume();
//		model.addAttribute("medicamente", medicamente);
		
		return "medicamenteReteta";
		
	}
	
	@RequestMapping(value = "/retetaM", params = "boala", method = RequestMethod.GET)
	public String  addMedicament(String searchText,@RequestParam("boala") String boala,@RequestParam(value = "medid", required = false) Integer medid,@RequestParam(value = "medid_remove", required = false) Integer medid_remove,Model model)
	{	 
		Reteta reteta = retetaService.findByName(boala);
		
		
		if(medid != null){
			Set<Medicament> reteta_medicament = reteta.getMedicamentList();
			reteta_medicament.add(medicamentService.findById(medid));
			reteta.setMedicamentList(reteta_medicament);
			retetaService.save(reteta);
			
			//salveazaza in tabela reteta specifica medicamentului
			Medicament medicament = medicamentService.findById(medid);
			medicament.getRetetaList().add(reteta);
			medicamentService.save(medicament);
		}
		if(medid_remove!=null){
			System.out.print(medid_remove);
			Set<Medicament> reteta_medicament = reteta.getMedicamentList();
		
			reteta_medicament.remove(medid_remove);
		
			reteta.setMedicamentList(reteta_medicament);
			retetaService.save(reteta);
			
			Medicament medicament = medicamentService.findById(medid_remove);
			medicament.getRetetaList().remove(reteta);
			medicamentService.save(medicament);
			
				
		}
		List<Medicament> medicamentList = medicamentService.findAll();
		
		model.addAttribute("medicamentList", medicamentList);
		model.addAttribute("reteta", reteta);
		return "medicamenteReteta";		
	}
	
}
