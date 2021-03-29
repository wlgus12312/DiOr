package com.dior.food.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dior.food.dto.menuDto;

public interface SignDao{
	ArrayList<menuDto> getMenu(JSONObject jObect) throws Exception;

	int getOrdersNo() throws Exception;	
	
		
	
	ArrayList<menuDto> getOrder(int ordno) throws Exception;

	ArrayList<menuDto> getSto() throws Exception;

	int getSto(JSONObject jObect) throws Exception;
	int insUser(JSONObject jObj) throws Exception;

	int insSto(JSONObject jObj) throws Exception;

	List getUserInfo(JSONObject jObect) throws Exception;

}
