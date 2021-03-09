package com.dior.food.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
	
	@MessageMapping("/food1")
	@SendTo("/topic/food1")
	public List<Map<String, Object>> food1() throws Exception {
		List<Map<String, Object>> msgList = null;		        
        msgList = OrderService.selectOrderList(1);        
        return msgList;

	}
	
	@MessageMapping("/food2")
	@SendTo("/topic/food2")
	public List<Map<String, Object>> food2() throws Exception {
		List<Map<String, Object>> msgList = null;		        
        msgList = OrderService.selectOrderList(2);        
        return msgList;
	}
	
	@MessageMapping("/food3")
	@SendTo("/topic/food3")
	public List<Map<String, Object>> food3() throws   Exception {
		List<Map<String, Object>> msgList = null;		        
        msgList = OrderService.selectOrderList(3);        
        return msgList;
	}
	
	
}
      