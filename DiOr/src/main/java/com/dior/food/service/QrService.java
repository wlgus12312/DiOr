package com.dior.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface QrService {
	

	int insert_QrCode(byte[] imageString, String stono, String tableno, String urlParam) throws Exception;

	List selectQr(String stono) throws Exception;
	
}
