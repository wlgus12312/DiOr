package com.dior.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dior.food.dao.QrDao;

@Service("QrService")
public class QrServiceImpl implements QrService{
	
	@Autowired
	private QrDao qrDao;

	@Override
	public int insert_QrCode(byte[] imageString, String stono, String tableno, String urlParam) throws Exception {
		
		int check = 0;
		check = qrDao.insert_QrCode(imageString, stono, tableno, urlParam);
		return check;
	}	

}
