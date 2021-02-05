package com.dior.food.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dior.food.dto.menuDto;

public interface MenuDao{
	ArrayList<menuDto> getMenu() throws Exception;	
}
