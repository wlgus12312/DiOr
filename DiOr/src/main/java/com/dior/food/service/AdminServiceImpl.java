package com.dior.food.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dior.food.dao.AdminDao;
import com.dior.food.dto.famFood;
import com.dior.food.dto.famQR;

@Service("AdminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao AdminDao;
	
	@Override
	public ArrayList<famFood> getStore() throws Exception{
		return AdminDao.getStore();
	}
	
	@Override
	public ArrayList<famFood> get_ResStore(Map menuMap) throws Exception{
		return AdminDao.get_ResStore(menuMap);
	}
	
	@Override
	public ArrayList<famFood> getFood() throws Exception{
		return AdminDao.getFood();
	}
	
	@Override
	public ArrayList<famFood> getFood(Map menuMap) throws Exception{
		return AdminDao.getFood(menuMap);
	}	

	@Override
	public ArrayList<famFood> get_ResFood(Map menuMap) throws Exception{
		return AdminDao.get_ResFood(menuMap);
	}
	
	@Override
	public ArrayList<famFood> get_ResFood2(Map menuMap) throws Exception{
		return AdminDao.get_ResFood2(menuMap);
	}	
	
	@Override
	public ArrayList<famFood> get_FoodList(Map menuMap) throws Exception {
		// TODO Auto-generated method stub
		return AdminDao.get_FoodList(menuMap); 
	}		

	public int setStore_Ins(Map storeMap) throws Exception{
		// TODO Auto-generated method stub
		int result = AdminDao.setStore_Ins(storeMap);
		return result;
	}
	
	public int setStore_Upd(Map storeMap) throws Exception{
		// TODO Auto-generated method stub
		int result = AdminDao.setStore_Upd(storeMap);
		return result;
	}	
	
	public int setMenu_Ins(Map menuMap) throws Exception{
		// TODO Auto-generated method stub
		int result = AdminDao.setMenu_Ins(menuMap);
		return result;
	}
	
	public int setMenu_Upd(Map menuMap) throws Exception{
		// TODO Auto-generated method stub
		int result = AdminDao.setMenu_Upd(menuMap);
		return result;
	}	
	
	public int setMenu_Del(Map menuMap) throws Exception{
		// TODO Auto-generated method stub
		int result = AdminDao.setMenu_Del(menuMap);
		return result;
	}
	
	@Override
	public ArrayList<famQR> getQR() throws Exception{
		return AdminDao.getQR();
	}
	
	public int setQR_Ins(Map qrMap) throws Exception{
		// TODO Auto-generated method stub
		int result = AdminDao.setQR_Ins(qrMap);
		return result;
	}
		
}
