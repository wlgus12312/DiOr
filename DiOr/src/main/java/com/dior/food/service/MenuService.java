package com.dior.food.service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dior.food.dto.menuDto;

public interface MenuService{
	ArrayList<menuDto> getMenu(JSONObject jObect) throws Exception;
	int insOrder(JSONArray jArr) throws Exception;
	ArrayList<menuDto> getOrder(int ordNo) throws Exception;
	ArrayList<menuDto> getSto() throws Exception;
}
