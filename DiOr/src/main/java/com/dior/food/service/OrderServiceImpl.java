package com.dior.food.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dior.food.dao.*;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao OrderDao;

	@Override
	public List<Map<String, Object>> selectOrderList(int i) throws Exception {
		
		List<Map<String, Object>> msgList = null;		
		msgList = OrderDao.selectOrderList(i);		
		return msgList;
	}

	@Override
	public void updatestOrder(HashMap<String, String> params) throws Exception {
		OrderDao.updatestOrder(params);
	}

	@Override
	public void updateedOrder(HashMap<String, String> params) throws Exception {
		OrderDao.updateedOrder(params);
		
	}

}
