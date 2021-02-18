package com.dior.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dior.food.config.OrMassage;
import com.dior.food.dao.OrderDaoImpl;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDaoImpl OrderDao;

	@Override
	public OrMassage selectOrderList(int i) throws Exception {
		
		OrMassage massage = OrderDao.selectOrderList(i);
		
		return massage;
	}

}
