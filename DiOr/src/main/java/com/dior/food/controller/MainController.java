package com.dior.food.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.AbstractView;

import com.dior.food.dao.AdminDao;
import com.dior.food.dto.famFood;
import com.dior.food.dto.famQR;
import com.dior.food.dto.menuDto;
import com.dior.food.service.*;
import com.dior.food.service.AdminService;
import com.dior.food.service.MainService;
import com.dior.food.service.MenuService;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@RestController
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainService MainService;
	@Autowired
	private MenuService MenuService;
	
	@Autowired
	private AdminService AdminService;
	
	
	//조리시작, 종료
	@Autowired
	private OrderService OrderService;
	
	
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest req) throws Exception{

		ModelAndView mv = new ModelAndView();
		List testList   = new ArrayList<famFood>();
		Map testMap     = new HashMap<String, Map<String, Object>>();
		
		testList = MainService.Maintest();
 
		mv.addObject("session", session.getId());
		mv.setViewName("index");
		
		return mv;
	}

	@RequestMapping("/menupan")
	public ModelAndView menupan(HttpServletRequest req) throws Exception{

		ModelAndView mv = new ModelAndView();
		List testList   = new ArrayList<famFood>();
		Map testMap     = new HashMap<String, Map<String, Object>>();
		  
		testList = MainService.Maintest();
		
		mv.addObject(testList);
		mv.setViewName("menupan");
		
		return mv;
	}
	  
	@RequestMapping("/menuAdmin")
	public ModelAndView menuAdmin(HttpServletRequest req, HttpServletResponse res) throws Exception{

		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();
		
		storeList = AdminService.getFood();
		mv.addObject("storeList",storeList);
		
		mv.setViewName("menuAdmin");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdmin_S_Pop")
	public ModelAndView menuAdmin_S_Pop(HttpServletRequest req) throws Exception{
			
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();

		storeList = AdminService.getStore();
		
		mv.addObject("storeList",storeList);
		mv.setViewName("menuAdmin_S_Pop");
		
		return mv;
	}
	
	@RequestMapping("/menuAdmin_S_Ins")
	public ModelAndView menuAdmin_S_Ins(HttpServletRequest req) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		Map storeMap     = new HashMap<String, Map<String, Object>>();
		
		storeMap.put("storeName", req.getParameter("storeName"));
		storeMap.put("storeTel", req.getParameter("storeTel"));
		
		int result = AdminService.setStore_Ins(storeMap);
		  
		mv.addObject("result",result);
		mv.setViewName("menuAdmin_S_Ins");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdmin_S_Upd")
	public ModelAndView menuAdmin_S_Upd(HttpServletRequest req) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		Map storeMap     = new HashMap<String, Map<String, Object>>();
		
		storeMap.put("sName", req.getParameter("sName"));
		storeMap.put("sId", req.getParameter("sId"));
		storeMap.put("sYn", req.getParameter("sYn"));
		
		int result = AdminService.setStore_Upd(storeMap);
		  
		mv.addObject("result",result);
		mv.setViewName("menuAdmin_S_Upd");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdmin_M_Pop")
	public ModelAndView menuAdmin_M_Pop(HttpServletRequest req) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();
				  
		storeList = AdminService.getStore();
		
		mv.addObject("storeList",storeList);
		mv.setViewName("menuAdmin_M_Pop");
		
		return mv;
	}
	
	@RequestMapping("/menuAdmin_M_Pop2")
	public ModelAndView menuAdmin_M_Pop2(HttpServletRequest req) throws Exception{
		
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
	//public ModelAndView menuAdmin_M_Ins(HttpServletRequest req) throws Exception{
	public ModelAndView menuAdmin_M_Ins(HttpServletRequest req, MultipartRequest req2) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		Map menuMap     = new HashMap<String, Map<String, Object>>();
		  
		menuMap.put("selectStore", req.getParameter("selectStore"));
		menuMap.put("menuName", req.getParameter("menuName"));
		menuMap.put("menuPrice", req.getParameter("menuPrice"));		
		menuMap.put("menuImage", req2.getFile("menuImage").getBytes());
		
		int result = AdminService.setMenu_Ins(menuMap);
		
		mv.addObject("result",result);
		
		mv.setViewName("menuAdmin_M_Ins");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdmin_M_Upd")
	public ModelAndView menuAdmin_M_Upd(HttpServletRequest req, MultipartRequest req2) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		Map menuMap     = new HashMap<String, Map<String, Object>>();
		  
		menuMap.put("mName", req.getParameter("mName"));
		menuMap.put("mPrice", req.getParameter("mPrice"));
		menuMap.put("mYn", req.getParameter("mYn"));
		menuMap.put("mNo", req.getParameter("mNo"));
		menuMap.put("mImage", req2.getFile("mImage").getBytes());
		
		int result = AdminService.setMenu_Upd(menuMap);
		
		mv.addObject("result",result);
		mv.setViewName("menuAdmin_M_Upd");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdmin_M_Del")
	public ModelAndView menuAdmin_M_Del(HttpServletRequest req) throws Exception{

		ModelAndView mv = new ModelAndView();
		Map menuMap     = new HashMap<String, Map<String, Object>>();
		
		menuMap.put("mNo", req.getParameter("mNo"));
		
		int result = AdminService.setMenu_Del(menuMap);
		
		mv.addObject("result",result);
		mv.setViewName("menuAdmin_M_Del");
		mv.clear();
		
		return mv;
	}	 
	
	@RequestMapping("/qrAdmin")
	public ModelAndView qrAdmin(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List qrList   = new ArrayList<famQR>();
		
		qrList = AdminService.getQR();
		mv.addObject("qrList",qrList);
		
		mv.setViewName("qrAdmin");
		
		return mv;
	}
	
	@RequestMapping("/qrAdmin_S_Pop")
	public ModelAndView qrAdmin_S_Pop(HttpServletRequest req) throws Exception{

		ModelAndView mv = new ModelAndView();
		List qrList   = new ArrayList<famQR>();
        
		qrList = AdminService.getQR();
		
		mv.addObject("qrList",qrList);
		mv.setViewName("qrAdmin_S_Pop");
		
		return mv;
	}
	
	@RequestMapping("/qrAdmin_S_Code")
	public ModelAndView qrAdmin_S_Code(HttpServletRequest req) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		  
		mv.setViewName("qrAdmin_S_Code");
		
		return mv;	
	}
	
	@RequestMapping("/qrAdmin_S_Ins")
	//public ModelAndView menuAdmin_M_Ins(HttpServletRequest req) throws Exception{
	public ModelAndView qrAdmin_S_Ins(HttpServletRequest req, MultipartRequest req2) throws Exception{
				
		ModelAndView mv = new ModelAndView();
		Map qrMap     = new HashMap<String, Map<String, Object>>();
		  
		qrMap.put("sYn", req.getParameter("sYn"));
		qrMap.put("sUrl", req.getParameter("sUrl"));
		qrMap.put("sImg", req.getParameter("hCode"));
		
		int result = AdminService.setQR_Ins(qrMap);
		
		mv.addObject("result",result);
		mv.setViewName("qrAdmin_S_Ins");
		
		return mv;
	}	


	
	//음식점 뷰
	@RequestMapping(value="/food", method=RequestMethod.POST)
	public ModelAndView food(HttpServletRequest request) throws Exception{				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("food");		
		String stono = request.getParameter("stono");
		mv.addObject("stono", stono);
		return mv;
	}	
	//조리시작 UPDATE
	@RequestMapping(value="/stOrder", method=RequestMethod.POST)
	public void stOrder(@RequestParam HashMap<String, String> params) throws Exception{				
		OrderService.updatestOrder(params);		
	}
	//조리시작 UPDATE
	@RequestMapping(value="/edOrder", method=RequestMethod.POST)
	public void edOrder(@RequestParam HashMap<String, String> params) throws Exception{				
		OrderService.updateedOrder(params);
	}

}
