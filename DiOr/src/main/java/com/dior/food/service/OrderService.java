package com.dior.food.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dior.food.config.OrMassage;

public interface OrderService {

	List<Map<String, Object>> selectOrderList(int i) throws Exception;

	void updatestOrder(HashMap<String, String> params) throws Exception;

	void updateedOrder(HashMap<String, String> params) throws Exception;
}
