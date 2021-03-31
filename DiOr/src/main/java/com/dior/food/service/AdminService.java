package com.dior.food.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.dior.food.dto.famFood;
import com.dior.food.dto.famQR;

public interface AdminService{
	ArrayList<famFood> getStore() throws Exception;	
	ArrayList<famFood> getFood() throws Exception;
	ArrayList<famFood> getFood(Map menuMap) throws Exception;
	ArrayList<famFood> get_ResStore(Map menuMap) throws Exception;
	ArrayList<famFood> get_ResFood(Map menuMap) throws Exception;
	ArrayList<famFood> get_ResFood2(Map menuMap) throws Exception;
	ArrayList<famFood> get_FoodList(Map menuMap) throws Exception; 
	ArrayList<famQR> getQR() throws Exception;
	int setStore_Ins(Map map) throws Exception;
	int setStore_Upd(Map map) throws Exception;
	int setMenu_Ins(Map map) throws Exception;
	int setMenu_Upd(Map map) throws Exception;
	int setMenu_Del(Map map) throws Exception;
	int setQR_Ins(Map qrMap) throws Exception;
	
}
