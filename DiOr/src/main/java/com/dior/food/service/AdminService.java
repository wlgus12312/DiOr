package com.dior.food.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.dior.food.dto.famFood;

public interface AdminService{

	ArrayList<famFood> getMenu() throws Exception;

}
