package com.dior.food.service;

import java.util.ArrayList;

import com.dior.food.dto.menuDto;

public interface MenuService{

	ArrayList<menuDto> getMenu() throws Exception;
	ArrayList<menuDto> getOrder(int ordNo) throws Exception;
}
