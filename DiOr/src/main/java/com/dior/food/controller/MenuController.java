package com.dior.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dior.food.dto.menuDto;
import com.dior.food.service.MenuServiceImpl;


@Controller
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuServiceImpl MenuService;
	
	@RequestMapping(value="/menupan", method=RequestMethod.GET)
	public ModelAndView menupan() throws Exception{
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menupan");
		
		
		ArrayList<menuDto> menuList   = new ArrayList<menuDto>();
		menuList = MenuService.getMenu();

		mv.addObject("menuList",menuList);
		
		//menuList.forEach(System.out :: println);
		return mv;
	}
	
	@RequestMapping(value="/insOrder", method=RequestMethod.POST)
	public ModelAndView insOrder(HttpServletRequest req) throws Exception{
		ModelAndView mv = new ModelAndView();
		ArrayList<menuDto> orderList   = new ArrayList<menuDto>();
		
		System.out.println("--------------------------------------");
//		System.out.println("param: tableno: " + req.getParameter("tableno")
//				         + " stono: " + req.getParameter("stono")
//						 + " fdno: " + req.getParameter("fdno")
//						 + " ordcnt: " + req.getParameter("ordcnt")
////						 + " ordstsc: " + req.getParameter("ordstsc")
//						 );
		
		int paramCnt = req.getParameterValues("stono").length;
		System.out.println("paramCnt: " + paramCnt);
		JSONArray jArr = new JSONArray();
		JSONObject jObect = null;
		for (int i = 0; i < paramCnt; i++) {
			jObect = new JSONObject();
			jObect.put("rowno", i);
			jObect.put("tableno", req.getParameterValues("tableno")[0]);
			jObect.put("stono", req.getParameterValues("stono")[i]);
			jObect.put("fdno", req.getParameterValues("fdno")[i]);
			jObect.put("ordcnt", req.getParameterValues("ordcnt")[i]);
			jArr.put(i, jObect);
		}
		
		int ordno = MenuService.insOrder(jArr);
		System.out.println("ordno : " + ordno);
		
		orderList = MenuService.getOrder(ordno);
		orderList.forEach(System.out :: println);
		
		mv.addObject("orderList",orderList);
		mv.addObject("ordno",ordno);
		
		//mv.addObject("session", session.getId());
		mv.setViewName("orderList");
		
		return mv;
	}	
		
	@RequestMapping(value="/orderList", method=RequestMethod.GET)
	public ModelAndView orderList(HttpServletRequest req) throws Exception{
		int ordno = 0;
		ordno = Integer.parseInt(req.getParameter("ordno"));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("orderList");
		
		List orderList   = new ArrayList<menuDto>();
		orderList = MenuService.getOrder(ordno);

		mv.addObject("orderList",orderList);
		
		//menuList.forEach(System.out :: println);
		return mv;
	}
}
