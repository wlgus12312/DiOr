package com.dior.food.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dior.food.dao.AdminDao;
import com.dior.food.dto.famFood;
import com.dior.food.dto.menuDto;
import com.dior.food.service.*;
import com.dior.food.service.AdminServiceImpl;
import com.dior.food.service.MainServiceImpl;
import com.dior.food.service.MenuServiceImpl;

@RestController
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainServiceImpl MainService;
	@Autowired
	private MenuServiceImpl MenuService;
	
	@Autowired
	private AdminServiceImpl AdminService;
	
	
	//조리시작, 종료
	@Autowired
	private OrderService OrderService;
	
	
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
	  
/*  
	@RequestMapping("/menuAdmin")
	public ModelAndView menuAdmin(HttpServletRequest req) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();

		storeList = AdminService.getFood();
		mv.addObject("storeList",storeList);
		
		mv.setViewName("menuAdmin");
		
		return mv;
	}
*/
	
	@RequestMapping("/menuAdmin")
	public ModelAndView menuAdmin(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();
		
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
	//public ModelAndView menuAdmin_M_Ins(HttpServletRequest req) throws Exception{
	public ModelAndView menuAdmin_M_Ins(HttpServletRequest req, MultipartRequest req2) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		//List storeList   = new ArrayList<famFood>();
		Map menuMap     = new HashMap<String, Map<String, Object>>();
		  
		menuMap.put("selectStore", req.getParameter("selectStore"));
		menuMap.put("menuName", req.getParameter("menuName"));
		menuMap.put("menuPrice", req.getParameter("menuPrice"));		
		menuMap.put("menuImage", req2.getFile("menuImage").getBytes());
		
		//System.out.println("*"+req2.getFile("menuImage").getBytes()+"*");
		
		
		int result = AdminService.setMenu_Ins(menuMap);
		
		mv.addObject("result",result);
		//mv.addObject("session", session.getId());
		mv.setViewName("menuAdmin_M_Ins");
		
		return mv;
	}	
	
	@RequestMapping("/menuAdmin_M_Upd")
	public ModelAndView menuAdmin_M_Upd(HttpServletRequest req, MultipartRequest req2) throws Exception{
		
		//HttpSession session = req.getSession();
		
		ModelAndView mv = new ModelAndView();
		//List storeList   = new ArrayList<famFood>();
		Map menuMap     = new HashMap<String, Map<String, Object>>();
		  
		menuMap.put("mName", req.getParameter("mName"));
		menuMap.put("mPrice", req.getParameter("mPrice"));
		menuMap.put("mYn", req.getParameter("mYn"));
		menuMap.put("mNo", req.getParameter("mNo"));
		menuMap.put("mImage", req2.getFile("mImage").getBytes());
		
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
	
	public static byte[] imageToByteArray(String filePath) throws Exception {
		byte[] returnValue = null;
		
		ByteArrayOutputStream baos = null;
		FileInputStream fis = null;
		
		try {
			baos = new ByteArrayOutputStream();
			fis = new FileInputStream(filePath);
			
			byte[] buf = new byte[1024];
			int read = 0;
			
			while((read=fis.read(buf, 0, buf.length)) != -1) {
				baos.write(buf, 0, read);
			}
			
			returnValue = baos.toByteArray();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(baos != null) {
				baos.close();
			}
			if(fis != null) {
				fis.close();
			}
		}
		
		return returnValue;
	}

	
	//음식점 뷰
	@RequestMapping(value="/food", method=RequestMethod.GET)
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
