package com.dior.food.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.dior.food.config.Greeting;
import com.dior.food.config.OrMassage;
import com.dior.food.service.OrderService;

@RestController
public class GreetingController {
	
	@Autowired
	private OrderService OrderService;
		
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(OrMassage message) throws Exception {
		return new Greeting("Hello");
	}
	
	@MessageMapping("/food{stono}")
	@SendTo("/topic/food{stono}")
	public List<Map<String, Object>> food(@PathVariable("stono") int stono) throws Exception {
		List<Map<String, Object>> msgList = null;		
		System.out.println("foodNo : " + stono);
        msgList = OrderService.selectOrderList(stono);        
        return msgList;
	}
	
	
	
}
      