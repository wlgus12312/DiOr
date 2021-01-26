package com.food.dior.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dior.dao.MainDaoImpl;

@Service("MainService")
public class MainServiceImpl implements MainService{
	
	@Autowired
	private MainDaoImpl MainDao;
	
	@Override
	public Map<String, Map<String, Object>> Maintest() throws Exception{
		return MainDao.getTest();
	}	
		
}
