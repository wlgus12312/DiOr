package com.dior.food.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.dior.food.dto.menuDto;

public interface MenuService{

	ArrayList<menuDto> getMenu() throws Exception;

}
