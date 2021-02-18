package com.dior.food.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dior.food.dao.AdminDaoImpl;
import com.dior.food.dto.famFood;

@Service("AdminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDaoImpl AdminDao;
	
	@Override
	public ArrayList<famFood> getMenu() throws Exception{
		return AdminDao.getMenu();
	}	
		
}
