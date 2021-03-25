package com.dior.food.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("QrDao")
public class QrDaoImpl implements QrDao{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert_QrCode(byte[] imageString, String stono, String tableno, String urlParam) throws Exception {
		
		int result = 0;
		String sql;
		
		try {
			sql = "INSERT INTO TB_QR(qrno, div, stono, fdno, url, qimg, rg_dt, ud_dt) \r\n"
					+ "VALUES((SELECT count(*) + 1 FROM TB_QR)"
					+ ", '1', ?, ?, ?, ?, getdate(), getdate())";
			jdbcTemplate.update(sql
					, stono
					, tableno
					, urlParam
					, imageString
					);		
		
		} catch (EmptyResultDataAccessException e) {
			result = -1;
		}
		return result;
	}

}
