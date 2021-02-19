package com.dior.food.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dior.food.dao.MenuDaoImpl;
import com.dior.food.dto.menuDto;

@Service("MenuService")
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDaoImpl MenuDao;
	
	@Override
	public ArrayList<menuDto> getMenu() throws Exception{
		return MenuDao.getMenu();
	}	
		
}
