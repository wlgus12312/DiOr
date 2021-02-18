package com.dior.food.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dior.food.dto.famFood;
import com.dior.food.dto.menuDto;
import com.dior.food.service.AdminServiceImpl;
import com.dior.food.service.MainServiceImpl;
import com.dior.food.service.MenuServiceImpl;


@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainServiceImpl MainService;
	@Autowired
	private MenuServiceImpl MenuService;
	
	@Autowired
	private AdminServiceImpl AdminService;
	
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
	
	@RequestMapping(value="/menupan", method=RequestMethod.GET)
	public ModelAndView menupan() throws Exception{
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menupan");
		
		
		List menuList   = new ArrayList<menuDto>();
		menuList = MenuService.getMenu();

		mv.addObject("menuList",menuList);
		
		//menuList.forEach(System.out :: println);
		return mv;
	}
	
	@RequestMapping("/menuAdmin")
	public ModelAndView menuAdmin(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();
		//Map testMap     = new HashMap<String, Map<String, Object>>();
		  
		storeList = AdminService.getMenu();
		
		mv.addObject("storeList",storeList);
		//mv.addObject("session", session.getId());
		mv.setViewName("menuAdmin");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdminStore")
	public ModelAndView menuAdminStore(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();
		//Map testMap     = new HashMap<String, Map<String, Object>>();
		  
		storeList = AdminService.getMenu();
		
		mv.addObject("storeList",storeList);
		//mv.addObject("session", session.getId());
		mv.setViewName("menuAdminStore");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdminMenu")
	public ModelAndView menuAdminMenu(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();
		//Map testMap     = new HashMap<String, Map<String, Object>>();
		  
		storeList = AdminService.getMenu();
		
		mv.addObject("storeList",storeList);
		//mv.addObject("session", session.getId());
		mv.setViewName("menuAdminMenu");
		
		return mv;
	}	
	
	
	@RequestMapping(value="/food1", method=RequestMethod.GET)
	public ModelAndView food1() throws Exception{
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("food1");
				
		List menuList   = new ArrayList<menuDto>();
		menuList = MenuService.getMenu();

		mv.addObject("menuList",menuList);
		
		return mv;
	}
	
	@RequestMapping(value="/food2", method=RequestMethod.GET)
	public ModelAndView food2() throws Exception{
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("food2");
				
		List menuList   = new ArrayList<menuDto>();
		menuList = MenuService.getMenu();

		mv.addObject("menuList",menuList);
		
		return mv;
	}	
	
	@RequestMapping(value="/food3", method=RequestMethod.GET)
	public ModelAndView food3() throws Exception{
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("food3");
				
		List menuList   = new ArrayList<menuDto>();
		menuList = MenuService.getMenu();

		mv.addObject("menuList",menuList);
		
		return mv;
	}	
	
	
	
	
		
}
