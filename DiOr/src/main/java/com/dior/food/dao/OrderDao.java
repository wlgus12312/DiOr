package com.dior.food.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dior.food.config.OrMassage;

public interface OrderDao {

	public List<Map<String, Object>> selectOrderList(int i) throws Exception;

	public void updatestOrder(HashMap<String, String> params) throws Exception;

	public void updateedOrder(HashMap<String, String> params) throws Exception;
}
