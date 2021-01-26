package com.dior.food.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dior.food.service.MainServiceImpl;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainServiceImpl MainService;
	
	@RequestMapping("/main")
	public ModelAndView main() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		Map testMap     = new HashMap<String, Map<String, Object>>();
				
		testMap = MainService.Maintest();
		
		mv.setViewName("index");
		
		return mv;
	}
	
	
}
