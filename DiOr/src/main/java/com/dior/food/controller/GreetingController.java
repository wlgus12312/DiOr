package com.dior.food.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.dior.food.config.Greeting;
import com.dior.food.config.OrMassage;

@RestController
public class GreetingController {
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(String message) throws Exception {
		//public Greeting greeting(OrMassage message) throws Exception {
		//Thread.sleep(100); // delay		
		//System.out.println(message.getOrMassage()+ "");
		System.out.println("message : " + message);
		
		//return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getOrMassage()) + "!");
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message) + "!");
	}
}
