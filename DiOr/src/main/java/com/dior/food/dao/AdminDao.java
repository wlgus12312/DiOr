package com.dior.food.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dior.food.dto.famFood;

public interface AdminDao{
	ArrayList<famFood> getMenu() throws Exception;	
}
