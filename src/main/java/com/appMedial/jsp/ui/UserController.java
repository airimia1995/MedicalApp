package com.appMedial.jsp.ui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.appMedial.jsp.bussines.MedicService;
import com.appMedial.jsp.bussines.PacientService;
import com.appMedial.jsp.bussines.UserService;
import com.appMedial.jsp.model.Medic;
import com.appMedial.jsp.model.Pacient;
import com.appMedial.jsp.model.Reteta;
import com.appMedial.jsp.model.User;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private PacientService pacientService;
	@Autowired
	private MedicService medicService;
	
	
	@RequestMapping(value ={ "/userLogin" }, method = RequestMethod.GET)
	public String logIN( ModelMap model) {
		return "logIn";
	}
	
	@RequestMapping(value ={ "/inserare" }, method = RequestMethod.GET)
	public String registration( ModelMap model) {
		User user = new User();
		model.addAttribute("userForm", user);
		return "inserare";
	
	}
	

	@RequestMapping(value = {"/inserare"}, method = RequestMethod.POST)
	public String saveUser( @ModelAttribute("userForm") @Valid User user,BindingResult result,  ModelMap model){
		
		if (result.hasErrors()) {
			 return "logIn";
	    }
		
		User u = userService.save(user);
		Pacient p = new Pacient();
		p.setUser(u);
		pacientService.save(p);
		
		return "redirect:/userLogin";
	}
	
	@RequestMapping(value={"/welcome"}, method = RequestMethod.GET)
	public String welcomeMedic(ModelMap model){
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
	      User user = userService.findByEmail(name);
	      model.addAttribute("user",user);
	      
	      Medic medic = medicService.findByUser(user);
	      List<Pacient> pacienti = pacientService.findAllByMedic(medic);
	      List<User> useri = new LinkedList<User>();
    	 
   	      for(Pacient p : pacienti){
   	    	  	useri.add(p.getUser());
   	      }
   	      model.addAttribute("useri",useri);
   	      
		return "welcome";
	}
	
	@RequestMapping(value={"/addPacient"}, method = RequestMethod.GET)
	public String addPacient( ModelMap model){
		
		return "addPacient";
	}
	
	@RequestMapping(value = "/addPacient", method = RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText, @RequestParam String action,ModelMap model){
		
		 User user = userService.findByEmail(searchText);
		 if( action.equals("search") ){
			 model.addAttribute("addPacient", user);
			 return "addPacient";
		    }
		 else if( action.equals("save") ){
		    	org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			    String name = auth.getName();
			    User user_curent = userService.findByEmail(name);
			    Medic m = medicService.findByUser(user_curent); 
				Pacient p=pacientService.findByUser(user);
				p.setMedic(m);
				pacientService.create(p);
		}
		return "addPacient";
	}
	@RequestMapping(value="/reteta-{user_email}-pacient",  method = RequestMethod.GET)
	public String reteta(@PathVariable String user_email, ModelMap model){
		
		User user = userService.findByEmail(user_email);
      	Pacient pacient = pacientService.findByUser(user);
        model.addAttribute("employee",pacient);
        Reteta reteta = new Reteta();
        model.addAttribute("reteta", reteta);
		return "reteta";
	}
	

}
