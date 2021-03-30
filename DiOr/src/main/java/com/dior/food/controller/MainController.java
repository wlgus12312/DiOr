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

import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.AbstractView;

import com.dior.food.dao.AdminDao;
import com.dior.food.dto.famFood;
import com.dior.food.dto.famQR;
import com.dior.food.dto.menuDto;
import com.dior.food.service.*;
import com.dior.food.service.AdminServiceImpl;
import com.dior.food.service.MainServiceImpl;
import com.dior.food.service.MenuServiceImpl;
import com.google.zxing.BarcodeFormat;
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
	@Autowired
	private QrService qrService;
	
	
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
				
		String urlParam = "http://brain21c.iptime.org:8080/menupan?stono="+stono+"?tableno="+tableno;
				
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




//DB저장값
//String hexString = "FFD8FFE000104A46494600010200000100010000FFDB004300080606070605080707070909080A0C140D0C0B0B0C1912130F141D1A1F1E1D1A1C1C20242E2720222C231C1C2837292C30313434341F27393D38323C2E333432FFDB0043010909090C0B0C180D0D1832211C213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232FFC00011080064006403012200021101031101FFC4001F0000010501010101010100000000000000000102030405060708090A0BFFC400B5100002010303020403050504040000017D01020300041105122131410613516107227114328191A1082342B1C11552D1F02433627282090A161718191A25262728292A3435363738393A434445464748494A535455565758595A636465666768696A737475767778797A838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE1E2E3E4E5E6E7E8E9EAF1F2F3F4F5F6F7F8F9FAFFC4001F0100030101010101010101010000000000000102030405060708090A0BFFC400B51100020102040403040705040400010277000102031104052131061241510761711322328108144291A1B1C109233352F0156272D10A162434E125F11718191A262728292A35363738393A434445464748494A535455565758595A636465666768696A737475767778797A82838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE2E3E4E5E6E7E8E9EAF2F3F4F5F6F7F8F9FAFFDA000C03010002110311003F00F7FA28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2803C4F5CD73E226B3F1835BF0B785B5FB4B182CADE3B844BA8232A14C716E01BCB6624B499E7DEAE7FC23DF1CFFE873D0FFEFCAFFF0023D1E1EFF93A1F167FD82A3FFD06D6BE60A00FA1EFB58F8A7E11F197852C3C43E26B1BBB5D5F50484A5A5BC6728248C3824C2A46449DBDFA55CF8BDF17A7F0FDD4BE1EF0F4D7767AD5A5C46D3DC34113C4D1345BB6AEEDC73974FE11D0F3EB97E24FF9A17FF6EDFF00B6B4CF8ADE0AD37C55E33D423F0C4F777FE310F1497DA7B3AC71456E2255DEACEAA09E61E3793F31E38E003A3F885E21F1B7FC2D5D27C29E14D660B0FB769FE7013C31B26F0662C4B14661F2C607147C47F10F8DB41FF841346D3359820D5F54CDADE4FE4C6D1CB3FEE5777CC870BB9D8F0A383D3B56A7C5192FA7274DD6A18EDBC0135BA36A7AA44737104A2425151724905D6107F76DC31E4751CBF8EA3B18759F83516973493E9E97112DACB20C33C41AD7631E0725707A0FA0A00D4FF847BE39FF00D0E7A1FF00DF95FF00E47AC7F14B7C67F08F872EF5CBFF001769525ADAECDE905BC65CEE7541806003AB0EF5E71F1B7FE4AF6BBFF6EFFF00A4F1D741E1EFF935EF167FD8563FFD0AD6803E87F09DF5C6A7E0DD0EFEF24F32EAEB4FB79A67DA06E768D4B1C0E06493D2B62B9FF027FC93CF0D7FD82AD7FF00452D7414005145140051451401E0FAC5F7893C23F1D3C43E21B0F06EABAD5ADD5A456C860864087F77092C1C2303831918FF000AAFFF000927FD5BDFFE487FF7356A6B9AE7C44D67E306B7E16F0B6BF69630595BC770897504654298E2DC03796CC496933CFBD761E35D5F5FF0AEB30F89E4BF8CF83ACADD56FEC228D5AE25959991593728E373C44FCE3853C7A8079A6A5A97893C63E32F02FF00C5BDD5743B1D1B508BFE5DE468D633245FF4C9422A88FE98F4C56DE9FAB69BA37ED33E2AB8D5350B4B181B4C8D164BA996252DB2D8E0162067009C7B1AB9FF0009B788BE287FC935D43FB1FF00B3BFE3FF00FB5618FF007BE67FABD98597A6C933F77A8EBDBCB3E28C963003A6EB50C973E3F86E11B53D52238B79E231928A8B900108D083FBB5E54F27A900D4F1B78B3FE1627842FBC45FF0907F637D9BCBB4FF008467EDBE67DB3122B79D8CAE7FD67F70FF00AAEBE9BFE2EB5D63FE11EF847AB693A25F6ABFD99690DCC915A42EFF00752D98292AA76E7691923B1EB8AE53E10D8780FC41751787BC43A25DDE6B57771234170B2BA44B12C5BB6B6D914E728FFC27A8E7D3D9FE20D978AF43F0ADA4BE08D4ED34BD3F46B295AE6299448CF1468BB1537A3E485461C919C8C93D8038BBEF19DE6A77925E5FFC069EEEEA4C6F9A7B4323B600032C6DB270001F85667897C45AF6B3E08D43C31A5FC21D4B4682F5D1D9AD6D9C2865746C9458141242019CFA7A569FC14F889E2AF1778CAF2C35CD57ED76B1E9EF32A7D9E28F0E248C0394507A31FCEB63ED7F12BC0FFF00151F8D3C4363A8F87ACFFE3EED6C214F3A4DFF00226DCC49D1D909F98700F5E8403D13C1704D6BE05F0F5BDC452433C5A65B2491C8A5591844A0820F2083C62B72A9E93A943ACE8D63AA5BAC8B05EDBC7711AC80060AEA18038246707D4D5CA0028A28A0028A28A00F13F8BDA1FC44F18DD4BA269DA05A4FA0C1711DC5B5CACF1A4AEC22C306DD20E373B8FBA3A0FC63F871ADE9DF093C3D71A078E2E3FB2B53B8BB6BD8A0D8D3EE85911036E88328F9A3718273C74E456E7897E2EEA5A378DF50F0C697E0CBBD667B244766B59D8B156446C945898800B819CFA7AD73FA978EB52D66E16E354F817777D3AA04592EAD9A560B92700B5B938C9271EE680384D0F4EF0378D7E21F88BFB7759BEB6FED0D54FF0064FD9108FB479B2BF5CC6DB7AC7F7B6FDE39F6F5BF00F83FC11E0EF883A8E9DA26AFA95C6BD0D915B9B5BAC154898C6FB8308D413CA7463D4F1E9CBE9BE36D36D7C55A1D95EFC1CB4D127BEBD8A2B6B99A0589918BA8DE9981492A581E08EDC8ADCB4FF890FED09E25D7359FF89769171A7C70417F79FB98259365BFC8B23614B7C8FC039F95BD0D0053D6BC77A67C4DF18D9780B4DBA8EE3C37AA5BEEBABA8A1922B84963DF2854320C63F771E72878279CF4C0F8A9A6C3E24D1B4FD2FC22D26A30782ADE7B7D51A42236B75454504EF0A1CE2093EE03F77DC66DFC4CF0A68F1E993FC40F046B963631E971476DE568888A1A46936B379B130DADB661918CE00EC6B62D7C6167A4783747FF00847FC25078AEFB53D3E3FEDEFB010F2093CB5CFDAB646E599CBCBF7F9243F5E6803C32F7C6BA95F780F4EF07CB05A0D3EC2E0DC4522A379A58990E18EEC63F78DD00E83F1FA6FE267887C13FD993F853C57ACCF61F6E8A3988821919F60932A4304651F3464735CBF86F57F0DDFEA3245E28F859A57852C444592FB53B58E38E4932311832428371059B19CE14F1E94FE2A780B52F1BFC5ED1ED228EEEDF4F934C092EA4B68D2C50B2B4CF86390327E518247DE1401EC1E1A8EC61F0AE9116973493E9E9650ADACB20C33C4106C63C0E4AE0F41F415A959FA1699FD89E1ED3349F3BCEFB0DA456DE6EDDBBF6205DD8C9C6719C64D68500145145001451450078FF0087BFE4E87C59FF0060A8FF00F41B5AF20FF85DBF10FF00E861FF00C92B7FFE375E8EDE29D1BC23FB4878A2FF005CBCFB25AC9A7C50ABF94F265CC76E40C2027A29FCAB98FF00847BE067FD0E7AE7FDF96FFE47A00E9FC677D71A9EA3F056FEF24F32EAEA582699F681B9D8DA96381C0C927A56C7C4CF885E02FED39FC29E2BD1755BFF00B0CB1CC441854DE63CA90C25563F2C84735CA788BC4BE17D67C55F0B74BF0C6A725F41A45EC36ECD242E8C177DBAA13B95412421E83B76AD3F889E29D1B5CF1DEA5E0AF1ADE7F66F87B4FF002AEADAEACE2733BCE624C2B1C38DB89643F747DD5E7D40353C5BE12B4F05584AE90C6BF0DD5164D5B478A477B8B8B867DAAE8CDF3001BC8240914610F07241B1F0D7405F0268DE27F16B2C6341D46DD352B1B68599E78AD95659151C3606FD8EA3EF119079EE7C02CACBC28FE03D46EEEF53BB8FC5097016CEC954F9524598F2CC76119C193F887DD1C7AFAFD9F8D752D2BE11DD697E3382D34D82FB42FB3F879A14676BC5F20AE5F6B38538687EF04FBC7D0E0024F127C65F86DE2ED3A3B0D7341D72EED63944CA9B523C38040394981E8C7F3AD8FF00868EF07FFD0375CFFBF10FFF001DAC3F85365E14F01F8334FF001FEAFA9DDDB4FA9A4B62C194C9103E6B1015510B03887A938EBEA2BD33C632F86BC472FF00C2BED5B519E0BED56259A3860460EC88C5F21CA141CC4DD7D3DC500749A4EA50EB3A358EA96EB22C17B6F1DC46B200182BA8600E0919C1F53572A9E93A6C3A368D63A5DBB48D0595BC76F1B484162A8A14138006703D055CA0028A28A0028A28A00C7BEF09F86F53BC92F2FF00C3FA55DDD498DF34F651C8ED8000CB11938000FC2ABFFC209E0FFF00A15343FF00C1743FFC4D741450061C1E0BF0ADADC45716FE1AD1A19E270F1C91D844AC8C0E41042E41079CD497DE13F0DEA77925E5FF0087F4ABBBA931BE69ECA391DB00019623270001F856C51401CFFF00C209E0FF00FA15343FFC1743FF00C4D5CBCF0D683A85BDADBDEE89A6DCC1689B2DA39AD51D615C0184046146140C0F41E95A9450065C9E1AD066D2E1D2E5D134D7D3E17DF15A35AA1891B9E5531807E66E40EE7D6AC49A4E9B36A90EA92E9F68FA8429B22BB6854CA8BCF0AF8C81F33700F73EB5728A0028A28A0028A28A0028A28A0028A28A0028A28A0028A28A0028A28A0028A28A0028A28A00FFD9";

//int len = imageString.length(); 
//byte[] hexArray = new byte[len / 2];
//
//for (int i = 0; i < len; i += 2) {
//	hexArray[i / 2] = (byte) ((Character.digit(imageString.charAt(i), 16) << 4)
//            + Character.digit(imageString.charAt(i+1), 16));
//}
//
//encodebyte = encoder.encode(hexArray);
//String imageString2 = new String(encodebyte, StandardCharsets.UTF_8);

	

