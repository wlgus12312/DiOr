package com.dior.food.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dior.food.dao.SignDao;

@Service("SignService")
public class SignServiceImpl implements SignService{
	
	@Autowired
	private SignDao SignDao;

	@Override
	public List getUserInfo(JSONObject jObect) throws Exception {
		return SignDao.getUserInfo(jObect);
	}

	@Override
	public int insUser(JSONObject jObj) throws Exception {
		int result = 0;

		try {
		int stono = SignDao.getSto(jObj);
		
		jObj.put("stono", stono);
		
		result = SignDao.insSto(jObj);
		
		result = SignDao.insUser(jObj);
		} catch (SQLException e){
			
			
		}
		return result;
	}

	@Override
	public int chkUser(JSONObject jObect) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
