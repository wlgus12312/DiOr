package com.dior.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dior.food.dto.signDto;
import com.dior.food.service.SignService;


@Controller
public class SignController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignController.class);
	
	@Autowired
	private SignService SignService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println("userid: " + req.getParameter("userid") + " / " + "userpw" + req.getParameter("userpw"));
		
		List userList = new ArrayList<signDto>();
		JSONObject jObect = new JSONObject();
		jObect.put("userid", req.getParameter("userid"));
		jObect.put("userpw", req.getParameter("userpw"));
		
		userList = SignService.getUserInfo(jObect);
		
		HttpSession session = req.getSession();
		session.setAttribute("userid", req.getParameter("userid"));
		session.setAttribute("stono", ((signDto) userList.get(0)).getStono());
		session.setAttribute("stonm", ((signDto) userList.get(0)).getStonm());
		session.setAttribute("apv_yn", ((signDto) userList.get(0)).getApv_yn());
		
		System.out.println(session.getAttribute("stono"));
		System.out.println(session.getAttribute("stonm"));
		System.out.println(session.getAttribute("apv_yn"));
		
		mv.addObject("userList",userList);
		mv.setViewName("index");
		return mv;
		
	}
	@RequestMapping(value="/signon", method=RequestMethod.GET)
	public ModelAndView signon() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signon");
		return mv;
	}
	
	
	@RequestMapping(value="/insUser", method=RequestMethod.POST)
	public ModelAndView insUser(HttpServletRequest req) throws Exception{
		int result = 0;
		ModelAndView mv = new ModelAndView();
		
		System.out.println("--------------------------------------");
		System.out.println(" stonm: " + req.getParameter("stonm")
				         + " userid: " + req.getParameter("userid")
						 + " userpw: " + req.getParameter("userpw")
						 + " tel: " + req.getParameter("tel")
//						 + " ordstsc: " + req.getParameter("ordstsc")
						 );
		
		JSONObject jObect = new JSONObject();
		jObect.put("stonm", req.getParameter("stonm"));
		jObect.put("userid", req.getParameter("userid"));
		jObect.put("userpw", req.getParameter("userpw"));
		jObect.put("stotel", "");
		jObect.put("tel", req.getParameter("tel"));

		result = SignService.insUser(jObect);
		mv.setViewName("signon");
		
		return mv;
	}	

//	@RequestMapping(value="/orderList", method=RequestMethod.GET)
//	public ModelAndView orderList(HttpServletRequest req) throws Exception{
//		
//		int ordno = 0;
//		ordno = Integer.parseInt(req.getParameter("ordno"));
//		System.out.println("다음ordno" + ordno);
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("orderList");
//		
//		List orderList   = new ArrayList<menuDto>();
//		orderList = SignService.getOrder(ordno);
//
//		mv.addObject("orderList",orderList);
//		
//		//menuList.forEach(System.out :: println);
//		return mv;
//	}
	
}
