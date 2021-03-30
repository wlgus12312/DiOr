package com.dior.food.dao;

import java.util.List;

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

	@Override
	public List select_QrCode(String stono) throws Exception {

		List reList = null;
		String sql;
		
		sql = "SELECT QRNO, STONO, FDNO, QIMG FROM brain_qr.dbo.TB_QR \r\n"
				+ " WHERE STONO = ?";
		reList = jdbcTemplate.queryForList(sql, stono);
		
		return reList;
		
	}

}
