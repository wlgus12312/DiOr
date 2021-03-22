package com.dior.food.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dior.food.dto.menuDto;

public interface MenuDao{
	ArrayList<menuDto> getMenu(JSONObject jObect) throws Exception;

	int getOrdersNo() throws Exception;	
	
	int insOrder(JSONObject jObj) throws Exception;	
	
	ArrayList<menuDto> getOrder(int ordno) throws Exception;

	ArrayList<menuDto> getSto() throws Exception;

}
