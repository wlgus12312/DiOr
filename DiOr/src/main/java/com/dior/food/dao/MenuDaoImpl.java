package com.dior.food.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.dior.food.dto.menuDto;

@Repository("MenuDao")
public class MenuDaoImpl implements MenuDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ArrayList<menuDto> getMenu(JSONObject jObect) throws Exception{	
		String sql = "";
		List<menuDto> menupan = null;
		
		try {
			
		sql = "select A.fdno, A.fdnm, A.fdprice, B.stonm, B.stono, A.timg \r\n"
				+ "from tb_food A, tb_store B\r\n"
				+ "where A.stono = B.stono\r\n"
				+ "and A.fdop_yn = 1 and B.stono = ? order by B.stono, A.fdno";
		
		System.out.println(sql); 
		
		menupan = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(menuDto.class), jObect.get("stono"));
		System.out.println("이미지"+ menupan.stream());

		menupan.forEach(System.out :: println);
		
		} catch (EmptyResultDataAccessException e) {
			System.out.println("SQL ERROR: "+e);
		}
		
		return (ArrayList<menuDto>) menupan;
	}

	@Override
	public int insOrder(JSONObject jObj) throws Exception {
		int result = 0;
		String sql;
		
		try {
			sql = "insert into tb_order (\r\n"
					+ "ordno, fdno, tabno, ordcnt, ordstsc,  rg_dt, ud_dt ) values (\r\n"
					+ " ? , ? , ? , ? , 0 , getdate(), getdate())";
		
			jdbcTemplate.update(sql
					, jObj.get("ordno")
					, jObj.get("fdno")
					, jObj.get("tabno")
					, jObj.get("ordcnt")
					);		
		
		} catch (EmptyResultDataAccessException e) {
			result = -1;
		}
		
		return result;
	}

	public ArrayList<menuDto> getOrder(int ordno) throws Exception{		
		ArrayList result = null;
		
		System.out.println("dao ordno:" + ordno);
		String sql = "select a.ordno\r\n"
				    + ", c.stono\r\n"
					+ ", c.stonm\r\n"
					+ ", b.fdno\r\n"
					+ ", b.fdnm\r\n"
					+ ", a.ordcnt\r\n"
					+ ", a.ordstsc\r\n"
					+ ", (CASE a.ordstsc WHEN '0' THEN '주문'\r\n"
					+ "				 WHEN '1' THEN '조리중'\r\n"
					+ "				 WHEN '2' THEN '조리완료'\r\n"
					+ "				 WHEN '3' THEN '딜레이'\r\n"
					+ "  END ) AS ordstnm"
					+ ", a.rg_dt\r\n"
					+ ", a.ud_dt\r\n"
					+ "from tb_order a, tb_food b, tb_store c\r\n"
					+ "where a.fdno = b.fdno \r\n"
					+ "and b.stono = c.stono\r\n"
					+ "and a.ordno = ?";
		System.out.println(sql);
		try {
			
			List<menuDto> ordList = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(menuDto.class), ordno);
			ordList.forEach(System.out :: println);
			result = (ArrayList<menuDto>) ordList;
			
		} catch (EmptyResultDataAccessException e) {
			System.err.println(e);
			result.add(e); 
		}
		
		return result;
	}

	public int getOrdersNo() {
		int ordersNo = 0; 
		String sql = "select isnull(max(ordno) + 1,1) from tb_order";
		ordersNo = jdbcTemplate.queryForObject(sql, int.class);	
		return ordersNo;
	}

	@Override
	public ArrayList<menuDto> getSto() throws Exception {
		String sql = "";
		List<menuDto> menupan = null;
		
		try {
			
		sql = "select stonm, stono from tb_store";
		
		System.out.println(sql); 
		
		menupan = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(menuDto.class));
		
		menupan.forEach(System.out :: println);
		
		} catch (EmptyResultDataAccessException e) {
			System.out.println("SQL ERROR: "+e);
		}
		
		return (ArrayList<menuDto>) menupan;
	}



}
