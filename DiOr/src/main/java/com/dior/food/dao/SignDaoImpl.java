package com.dior.food.dao;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dior.food.dto.menuDto;
import com.dior.food.dto.signDto;

@Repository("SignDao")
public class SignDaoImpl implements SignDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public List getUserInfo(JSONObject jObect) throws Exception {
		String sql = "";
		List<signDto> signDto = null;
		
		try {
			
		sql = "select A.userid \r\n"
				+ ", A.stono \r\n"
				+ ", B.stonm \r\n"
				+ ", A.apv_yn \r\n"
				+ ", A.tel \r\n"
				+ "from tb_user A, tb_store B \r\n"
				+ "where A.stono = B.stono \r\n"
				+ "and A.userid = ? \r\n"
				+ "and A.userpw = ?";
		
		System.out.println(sql); 
		
		signDto = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(signDto.class), jObect.get("userid"), jObect.get("userpw"));

		signDto.forEach(System.out :: println);
		
		} catch (EmptyResultDataAccessException e) {
			System.out.println("SQL ERROR: "+e);
		}
		
		return (ArrayList<signDto>) signDto;
	}

	
	@Override
	public int getSto(JSONObject jObect) {
		int stoNo = 0; 
		String sql = "select isnull(max(stono) + 1,1) from tb_store ";
		try {
			stoNo = jdbcTemplate.queryForObject(sql, int.class);	
		} catch (EmptyResultDataAccessException e) {
			System.out.println("SQL ERROR: " + e);
		}
		return stoNo;
	}

	

	@Override
	public int insSto(JSONObject jObj) throws Exception {
		int result = 0;
		String sql;
		
		try {
			sql = "insert into tb_store (\r\n"
					+ "stono, stonm, stotel, rg_dt, ud_dt ) values (\r\n"
					+ "? , ? , ? , getdate(), getdate())";
		
			jdbcTemplate.update(sql
					, jObj.get("stono")
					, jObj.get("stonm")
					, jObj.get("stotel")
					);		
		
		} catch (EmptyResultDataAccessException e) {
			result = -1;
		}
		
		return result;
	}

	@Override
	public int insUser(JSONObject jObj) throws Exception {
		int result = 0;
		String sql;
		
		try {
			sql = "insert into tb_user (\r\n"
					+ "userid, userpw, stono, tel, apv_yn,  rg_dt, ud_dt ) values (\r\n"
					+ " ? , ? , ? , ? , 0 , getdate(), getdate())";
		
			jdbcTemplate.update(sql
					, jObj.get("userid")
					, jObj.get("userpw")
					, jObj.get("stono")
					, jObj.get("tel")
					);		
		
		} catch (EmptyResultDataAccessException e) {
			result = -1;
		}
		
		
		
		return result;
	}
	
	@Override
	public ArrayList<menuDto> getMenu(JSONObject jObect) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public ArrayList<signDto> getMenu(JSONObject jObect) throws Exception{	
//		String sql = "";
//		List<menuDto> menupan = null;
//		
//		try {
//			
//		sql = "select A.fdno, A.fdnm, A.fdprice, B.stonm, B.stono, A.timg \r\n"
//				+ "from tb_food A, tb_store B\r\n"
//				+ "where A.stono = B.stono\r\n"
//				+ "and A.fdop_yn = 1 and B.stono = ? order by B.stono, A.fdno";
//		
//		System.out.println(sql); 
//		
//		menupan = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(menuDto.class), jObect.get("stono"));
//		System.out.println("이미지"+ menupan.stream());
//
//		menupan.forEach(System.out :: println);
//		
//		} catch (EmptyResultDataAccessException e) {
//			System.out.println("SQL ERROR: "+e);
//		}
//		
//		return (ArrayList<menuDto>) menupan;
//	}

	
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

	@Override
	public int getOrdersNo() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



}
