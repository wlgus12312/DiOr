package com.dior.food.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dior.food.dto.menuDto;

public interface SignService{
	int chkUser(JSONObject jObect) throws Exception;
	int insUser(JSONObject jObect) throws Exception;
	List getUserInfo(JSONObject jObect)throws Exception;
}
