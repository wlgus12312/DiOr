package com.dior.food.controller;

import java.io.ByteArrayOutputStream;

import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dior.food.dto.famFood;
import com.dior.food.dto.famQR;
import com.dior.food.service.*;
import com.google.zxing.BarcodeFormat;
import com.dior.food.service.AdminService;
import com.dior.food.service.MainService;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@RestController
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainService MainService;
	
	@Autowired
	private AdminService AdminService;
	
	
	//조리시작, 종료
	@Autowired
	private OrderService OrderService;
	@Autowired
	private QrService qrService;
	
	@Value("${server.port}")
    private String serverPort;
	
	@Value("${server.url}")
    private String serverUrl;
	
	
	
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest req) throws Exception{

		ModelAndView mv = new ModelAndView();
		List testList   = new ArrayList<famFood>();
		Map testMap     = new HashMap<String, Map<String, Object>>();
		
		testList = MainService.Maintest();
 
		mv.setViewName("index");
		
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
	
	@RequestMapping("/foodList") 
	public ModelAndView foodList(HttpServletRequest req, HttpServletResponse res) throws Exception{

		ModelAndView mv = new ModelAndView();
		Map storeMap     = new HashMap<String, Map<String, Object>>();
		List storeList   = new ArrayList<famFood>();
		
		HttpSession session = req.getSession();
		//session.getAttribute("stono");
		
		storeMap.put("stono", session.getAttribute("stono")); //Test.. 화면에서 레스토랑ID 받아서 처리예정
		storeList = AdminService.get_FoodList(storeMap);
		
		mv.addObject("storeList",storeList);
		//mv.addObject("storeMap",storeMap);
		mv.setViewName("foodList");
		
		return mv;
	}	
	
	@RequestMapping("/menu_Res_Admin")
	public ModelAndView menu_Res_Admin(HttpServletRequest req, HttpServletResponse res) throws Exception{

		ModelAndView mv = new ModelAndView();
		Map storeMap     = new HashMap<String, Map<String, Object>>();
		List storeList   = new ArrayList<famFood>();
		
		//storeMap.put("storeId", req.getParameter("storeId"));
		storeMap.put("storeId", req.getParameter("stono")); //Test.. 화면에서 레스토랑ID 받아서 처리예정 
		
		storeList = AdminService.get_ResFood(storeMap);
		
		mv.addObject("storeList",storeList);
		mv.addObject("storeMap",storeMap);
		mv.setViewName("menu_Res_Admin");
		
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
	
	@RequestMapping("/menu_Res_Admin_M_Pop")
	public ModelAndView menu_Res_Admin_M_Pop(HttpServletRequest req) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List storeList   = new ArrayList<famFood>();
		
		Map storeMap     = new HashMap<String, Map<String, Object>>();
				  
		storeMap.put("storeId", req.getParameter("storeId"));
		
		storeList = AdminService.get_ResStore(storeMap);
		
		mv.addObject("storeList",storeList);
		mv.setViewName("menu_Res_Admin_M_Pop");
		
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
		menuMap.put("mSize", req2.getFile("mImage").getSize());
		
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
	
	
	@RequestMapping(value="/tableQr")
	public ModelAndView tableQr() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tableQr");
		return mv;
	}
	
		
	//바코드 생성
	@ResponseBody
	@RequestMapping(value="/createQr", method=RequestMethod.POST)
	public Map createQr(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		//qr 코드 생성		
		String stono   = req.getParameter("stono");
		String tableno = req.getParameter("tableno");
				
		System.out.println("server.url : " + serverUrl + "/port: " +serverPort);
		
		String urlParam = serverUrl + ":" + serverPort + "/menupan?stono="+stono+"&tableno="+tableno;
				
		String url = new String (urlParam.getBytes("UTF-8"),"ISO-8859-1");		
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		byte[] encodebyte = null;
		byte[] imagefile = new byte[1024];
		String imageString = "";
		
		Encoder encoder = Base64.getEncoder();
		
		try {
			
		    BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 100, 100);
		    
		    //stream
			MatrixToImageWriter.writeToStream(bitMatrix, "png", baos);
			
			//stream > bytearray
			imagefile = baos.toByteArray();
			
			//bytearray > base64
			encodebyte = encoder.encode(imagefile);
			
			//base64 > string
			imageString = new String(encodebyte, StandardCharsets.UTF_8);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			baos.flush();
			baos.close();
		}
		
		//imagefile을 DB에 저장해야함 DB에서 byteArray > hex로 바꺼줌
		int check = 0;
		check = qrService.insert_QrCode(imagefile, stono, tableno, urlParam);
		
		Map reMap = new HashMap<>();
		reMap.put("qrCode", imagefile);
		
		//ModelAndView mv = new ModelAndView();			
		//mv.setViewName("qrList");
		
		//mv.addObject("qrCode",imageString);		
		return reMap;
		
	}		
	
	//바코드 생성
		@ResponseBody
		@RequestMapping(value="/selectQr", method=RequestMethod.POST)
		public List selectQr(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
			List reList = new ArrayList<Map>();			
			String stono   = req.getParameter("stono");
			
			reList = qrService.selectQr(stono);
			
			return reList;
		}
	
		
	
	
}
