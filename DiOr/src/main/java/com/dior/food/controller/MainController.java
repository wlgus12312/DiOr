package com.dior.food.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dior.food.dto.famFood;
import com.dior.food.service.MainServiceImpl;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainServiceImpl MainService;
	
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest req) throws Exception{
		
		HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List testList   = new ArrayList<famFood>();
		Map testMap     = new HashMap<String, Map<String, Object>>();
		  
		testList = MainService.Maintest();
		
		//mv.addObject(testList);
		mv.addObject("session", session.getId());
		mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping("/menupan")
	public ModelAndView menupan(HttpServletRequest req) throws Exception{
		
		HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List testList   = new ArrayList<famFood>();
		Map testMap     = new HashMap<String, Map<String, Object>>();
		  
		testList = MainService.Maintest();
		
		mv.addObject(testList);
		//mv.addObject("session", session.getId());
		mv.setViewName("menupan");
		
		return mv;
	}
		
}
