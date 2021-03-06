package com.dior.food.service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dior.food.dao.MenuDao;
import com.dior.food.dto.menuDto;

@Service("MenuService")
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDao MenuDao;
	
	@Override
	public ArrayList<menuDto> getMenu(JSONObject jObect) throws Exception{
		return MenuDao.getMenu(jObect);
	}

	public int insOrder(JSONArray jArr) throws Exception {
		int result = 0;
		int ordersNo = 0;
		JSONObject jObj = new JSONObject();
		ordersNo = MenuDao.getOrdersNo();
		System.out.println("orders No: "+ordersNo);
		
		for(int i=0;i<jArr.length();i++){
			jObj = (JSONObject)jArr.get(i);
			jObj.put("ordno", ordersNo);
			result = MenuDao.insOrder(jObj);
			if(result < 0) { //에러
				return result;
			} else {
				result = ordersNo;
			}
		}
			
		return result;
	}

	public ArrayList<menuDto> getOrder(int ordNo) throws Exception{
		System.out.println("service");
		return MenuDao.getOrder(ordNo);
	}

	@Override
	public ArrayList<menuDto> getSto() throws Exception {
		return MenuDao.getSto();
	}

}
