package com.appMedial.jsp.ui;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appMedial.jsp.model.ChatMessage;

@Controller
public class MessageController {
  
  private SimpMessagingTemplate template;
  
  @Inject
  public MessageController(SimpMessagingTemplate template) {
    this.template = template;
  }
  //@MessageMapping("/chat")
  @RequestMapping(value ={ "/chat"},method = RequestMethod.GET)
  public String view() throws Exception{
//	  System.out.println("adasdasdasd");Message<Object> message, @Payload ChatMessage chatMessage
//	  //Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
//	  //System.out.print("BLABLABLA    "+principal.getName());
//	    String authedSender = SecurityContextHolder.getContext().getAuthentication().getName();
//	    System.out.print("crac"+authedSender);
//	    chatMessage.setSender(authedSender);
//	    String recipient = chatMessage.getRecipient();
//	    if (!authedSender.equals(recipient)) {
//	      template.convertAndSendToUser(authedSender, "/queue/messages", chatMessage);
//	    }
//	    
//	    template.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
	  
	  return "index";
  }
  @MessageMapping("/chat")
  public void greeting(Message<Object> message, @Payload ChatMessage chatMessage) throws Exception {
    Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
    String authedSender = principal.getName();
    chatMessage.setSender(authedSender);
    String recipient = chatMessage.getRecipient();
    if (!authedSender.equals(recipient)) {
      template.convertAndSendToUser(authedSender, "/queue/messages", chatMessage);
    }
    
    template.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
  }

}