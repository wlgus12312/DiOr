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
import com.dior.food.service.MainService;
import com.dior.food.service.MainServiceImpl;
import com.dior.food.service.AdminService;
import com.dior.food.service.AdminServiceImpl;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainServiceImpl MainService;
	
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
	
	@RequestMapping("/menuAdmin")
	public ModelAndView menuAdmin(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();
		/*  
		storeList = AdminService.getStore();
		
		mv.addObject("storeList",storeList);
		//mv.addObject("session", session.getId());
		*/
		storeList = AdminService.getFood();
		mv.addObject("storeList",storeList);
		
		mv.setViewName("menuAdmin");
		
		return mv;
	}
	
	@RequestMapping("/menuAdmin_S_Pop")
	public ModelAndView menuAdmin_S_Pop(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();
		//Map storeMap     = new HashMap<String, Map<String, Object>>();
		
		//storeMap.put("storeId", req.getParameter("storeId"));
		//storeMap.put("storeName", req.getParameter("storeName"));
		
		//int result = AdminService.setStore_Ins(storeMap);
		  
		//storeList = AdminService.getMenu();
		
		storeList = AdminService.getStore();
		
		mv.addObject("storeList",storeList);
		//mv.addObject("result",result);
		//mv.addObject("session", session.getId());
		mv.setViewName("menuAdmin_S_Pop");
		
		return mv;
	}
	
	@RequestMapping("/menuAdmin_S_Ins")
	public ModelAndView menuAdmin_S_Ins(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		//List storeList   = new ArrayList<famFood>();
		Map storeMap     = new HashMap<String, Map<String, Object>>();
		
		storeMap.put("storeName", req.getParameter("storeName"));
		
		int result = AdminService.setStore_Ins(storeMap);
		  
		//storeList = AdminService.getMenu();		
		mv.addObject("result",result);
		//mv.addObject("session", session.getId());
		mv.setViewName("menuAdmin_S_Ins");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdmin_S_Upd")
	public ModelAndView menuAdmin_S_Upd(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		//List storeList   = new ArrayList<famFood>();
		Map storeMap     = new HashMap<String, Map<String, Object>>();
		
		storeMap.put("sName", req.getParameter("sName"));
		storeMap.put("sId", req.getParameter("sId"));
		storeMap.put("sYn", req.getParameter("sYn"));
		
		int result = AdminService.setStore_Upd(storeMap);
		  
		//storeList = AdminService.getMenu();		
		mv.addObject("result",result);
		//mv.addObject("session", session.getId());
		mv.setViewName("menuAdmin_S_Upd");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdmin_M_Pop")
	public ModelAndView menuAdmin_M_Pop(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();
		//Map testMap     = new HashMap<String, Map<String, Object>>();
		  
		storeList = AdminService.getStore();
		
		mv.addObject("storeList",storeList);
		mv.setViewName("menuAdmin_M_Pop");
		
		return mv;
	}
	
	@RequestMapping("/menuAdmin_M_Pop2")
	public ModelAndView menuAdmin_M_Pop2(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List menuList   = new ArrayList<famFood>();
		Map menuMap     = new HashMap<String, Map<String, Object>>();
		
		menuMap.put("menuId", req.getParameter("menuId"));
		  
		menuList = AdminService.getFood(menuMap);
		
		mv.addObject("menuList",menuList);
		mv.setViewName("menuAdmin_M_Pop2");
		
		return mv;
	}		
	
	@RequestMapping("/menuAdmin_M_Ins")
	public ModelAndView menuAdmin_M_Ins(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		//List storeList   = new ArrayList<famFood>();
		Map menuMap     = new HashMap<String, Map<String, Object>>();
		  
		menuMap.put("selectStore", req.getParameter("selectStore"));
		menuMap.put("menuName", req.getParameter("menuName"));
		menuMap.put("menuPrice", req.getParameter("menuPrice"));
		menuMap.put("menuImage", req.getParameter("menuImage"));
		
		int result = AdminService.setMenu_Ins(menuMap);
		
		mv.addObject("result",result);
		//mv.addObject("session", session.getId());
		mv.setViewName("menuAdmin_M_Ins");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdmin_M_Upd")
	public ModelAndView menuAdmin_M_Upd(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		//List storeList   = new ArrayList<famFood>();
		Map menuMap     = new HashMap<String, Map<String, Object>>();
		  
		menuMap.put("mName", req.getParameter("mName"));
		menuMap.put("mPrice", req.getParameter("mPrice"));
		//menuMap.put("mImage", req.getParameter("mImage"));
		menuMap.put("mYn", req.getParameter("mYn"));
		menuMap.put("mNo", req.getParameter("mNo"));
		
		int result = AdminService.setMenu_Upd(menuMap);
		
		mv.addObject("result",result);
		//mv.addObject("session", session.getId());
		mv.setViewName("menuAdmin_M_Upd");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdmin_M_Del")
	public ModelAndView menuAdmin_M_Del(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		//List storeList   = new ArrayList<famFood>();
		Map menuMap     = new HashMap<String, Map<String, Object>>();
		
		menuMap.put("mNo", req.getParameter("mNo"));
		
		int result = AdminService.setMenu_Del(menuMap);
		
		mv.addObject("result",result);
		//mv.addObject("session", session.getId());
		mv.setViewName("menuAdmin_M_Del");
		mv.clear();
		
		return mv;
	}	
		
}
