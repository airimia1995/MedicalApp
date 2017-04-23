//package com.appMedial.jsp.ui;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.appMedial.jsp.bussines.MedicamentService;
//import com.appMedial.jsp.bussines.MesajeService;
//import com.appMedial.jsp.bussines.UserService;
//import com.appMedial.jsp.model.Mesaje;
//import com.appMedial.jsp.model.User;
//
//@Controller
//public class Chat {
//	@Autowired 
//	private MesajeService mesajeService;
//	@Autowired
//	private UserService userService;
//	
////	@RequestMapping(value ={ "/userList"},method = RequestMethod.GET)
////	public String  afisareUseri(ModelMap model){
////		List<User> users = userService.findAll();
////		model.addAttribute("users", users);
////		return "userList";
////	}
////	@RequestMapping(value ={ "/chat"},params = "mail",method = RequestMethod.GET)
////	public String chatInit(@RequestParam("mail") String mail, ModelMap model){
////		System.out.print(SecurityContextHolder.getContext().getAuthentication().getName());
////		System.out.print(mail);
////		List<Mesaje> mesaje = mesajeService.findByReceiver_idAndSender_id(mail, SecurityContextHolder.getContext().getAuthentication().getName());
////		
////		model.addAttribute("mesajeRead",mesaje);
////		model.addAttribute("mail",mail);
////		return "chat";
////	}
////	
////	@RequestMapping(value ={ "/chat"},params = "mail",method = RequestMethod.POST)
////	public String  chat(@RequestParam(value = "mail") String mail,@ModelAttribute("mesaje") Mesaje mesaj, ModelMap model){
//////		Mesaje mesaj = new Mesaje();
//////		mesaj.setMesaj("blablabla");
////		
////		mesaj.setReceiver_email(mail);
////		mesaj.setSender_email(SecurityContextHolder.getContext().getAuthentication().getName());
////		mesajeService.save(mesaj);
////		//model.addAttribute("mesaj", mesaj);
////		model.addAttribute("mail",mail);
////		System.out.print(SecurityContextHolder.getContext().getAuthentication().getName());
////		System.out.print(mail);
////		
////		return "chat";
////	}
//}
