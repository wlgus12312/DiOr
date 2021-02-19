package com.dior.food.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.dior.food.dto.famFood;

public interface AdminService{
	ArrayList<famFood> getStore() throws Exception;
	ArrayList<famFood> getFood() throws Exception;
	ArrayList<famFood> getFood(Map menuMap) throws Exception;
	int setStore_Ins(Map map) throws Exception;
	int setStore_Upd(Map map) throws Exception;
	int setMenu_Ins(Map map) throws Exception;
	int setMenu_Upd(Map map) throws Exception;
	int setMenu_Del(Map map) throws Exception;
	
}
