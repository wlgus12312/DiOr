package com.dior.food.dao;

import java.util.List;

public interface QrDao {

	int insert_QrCode(byte[] imageString, String stono, String tableno, String urlParam) throws Exception;

	List select_QrCode(String stono) throws Exception;

	
}
