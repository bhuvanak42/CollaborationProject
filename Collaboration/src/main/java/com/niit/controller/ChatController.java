package com.niit.controller;

import java.security.Principal;
import java.util.Date;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Message;
import com.niit.model.OutputMessage;

@Controller
public class ChatController {

	@RequestMapping("/chatPage")
	public ModelAndView chat() {
		ModelAndView model = new ModelAndView("chat");
		return model;
	}
	
	
	@MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message) {
		System.out.println(message.getMessage());
		//String usersName=(String) session.getAttribute("loggedInUserName");
	    return new OutputMessage(message, new Date());
	  }
}
