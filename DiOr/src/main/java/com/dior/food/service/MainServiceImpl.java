package com.dior.food.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dior.food.dao.MainDaoImpl;

@Service("MainService")
public class MainServiceImpl implements MainService{
	
	@Autowired
	private MainDaoImpl MainDao;
	
	@Override
	public Map<String, Map<String, Object>> Maintest() throws Exception{
		return MainDao.getTest();
	}	
		
}
