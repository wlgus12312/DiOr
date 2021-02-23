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
import com.dior.food.service.OrderServiceImpl;

@RestController
public class GreetingController {
	
	@Autowired
	private OrderServiceImpl OrderService;
		
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
	public Greeting food2(OrMassage message) throws Exception {
		return new Greeting(message.getOrdno());
	}
	
	@MessageMapping("/food3")
	@SendTo("/topic/food3")
	public Greeting food3(OrMassage message) throws Exception {
		return new Greeting(message.getOrdno());
	}
	
	
}
      