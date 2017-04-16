package com.appMedial.jsp.ui;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appMedial.jsp.bussines.PacientService;
import com.appMedial.jsp.bussines.UserService;
import com.appMedial.jsp.model.Pacient;
import com.appMedial.jsp.model.User;






@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private PacientService pacientService;
	
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
	      System.out.print(name);
	      User user = userService.findByEmail(name);
	      model.addAttribute("user",user);
		return "welcome";
	}
}
