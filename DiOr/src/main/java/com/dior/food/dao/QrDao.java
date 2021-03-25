package com.dior.food.dao;

public interface QrDao {

	int insert_QrCode(byte[] imageString, String stono, String tableno, String urlParam) throws Exception;

}
