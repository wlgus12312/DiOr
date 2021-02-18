package com.dior.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.dior.food.config.Greeting;
import com.dior.food.config.OrMassage;
import com.dior.food.service.OrderServiceImpl;

@RestController
public class GreetingController {
	
	@Autowired
	private OrderServiceImpl OrderService;
		
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(OrMassage message) throws Exception {
		//Thread.sleep(100); // delay
		return new Greeting("Hello");
	}
	
	@MessageMapping("/food1")
	@SendTo("/topic/food1")
	public Greeting food1() throws Exception {
		
		System.out.println("1");
		
        OrMassage massage = null;
        
		massage = OrderService.selectOrderList(1);
		
		Greeting grt = new Greeting(massage.toString());
		
		return grt;
	}
	
	@MessageMapping("/food2")
	@SendTo("/topic/food2")
	public Greeting food2(OrMassage message) throws Exception {
		return new Greeting(message.getOrdno());
	}
	
	@MessageMapping("/food3")
	@SendTo("/topic/food3")
	public Greeting food3(OrMassage message) throws Exception {
		return new Greeting(message.getOrdno());
	}
}
      