package com.dior.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface QrService {
	

	int insert_QrCode(byte[] imageString, String stono, String tableno, String urlParam) throws Exception;
	
}
