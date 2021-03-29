package com.dior.food.dao;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dior.food.dto.famFood;
import com.dior.food.dto.famQR;

@Repository("AdminDao")
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public ArrayList<famFood> getStore() throws Exception{				
		String sql = "SELECT * FROM TB_STORE";
		List<famFood> foods = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(famFood.class));		
		
		//foods.forEach(System.out :: println);
		
		return (ArrayList<famFood>) foods;
	}
	
	@Override
	public ArrayList<famFood> get_ResStore(Map menuMap) throws Exception{				
		String sql = "SELECT * FROM TB_STORE"
				   + " WHERE STONO = " + menuMap.get("storeId");
		List<famFood> foods = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(famFood.class));		
		
		//foods.forEach(System.out :: println);
		
		return (ArrayList<famFood>) foods;
	}
	
	@Override
	public ArrayList<famFood> getFood() throws Exception{				
		String sql = "SELECT A.STONO   " 
				   + "     , A.STONM    "  
				   + "     , A.STOTEL   "
				   + "     , B.FDNO     "
			 	   + "     , B.FDNM     "
		 		   + "     , Replace(Convert(Varchar, Convert(Money, B.FDPRICE),112),'.00','') AS FDPRICE  "
	 			   + "     , CASE WHEN B.FDOP_YN = 1 THEN '오픈' ELSE '미오픈' END AS FDOP_YN   "
 			       //+ "     , B.FDIMG    "
 			      + "     , B.TIMG    "
				   + "  FROM TB_STORE A "
				   + "     , TB_FOOD  B "
				   + " WHERE A.STONO = B.STONO "
				   + " ORDER BY A.STONO ASC, B.FDNO ";
		List<famFood> foods = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(famFood.class));		
       
		for(int i=0; i<foods.size(); i++) {
			if(foods.get(i).getTimg() != null) {
				byte[] bt = foods.get(i).getTimg();
	            String vimg = new String( Base64.encodeBase64(bt));
	            foods.get(i).setVimg(vimg);
			}
		}
		
		return (ArrayList<famFood>) foods;
	}	
	
	@Override
	public ArrayList<famFood> getFood(Map menuMap) throws Exception {
		String sql = "SELECT A.STONO   " 
				   + "     , A.STONM    "
				   + "     , A.STOTEL   "
				   + "     , B.FDNO     "
			 	   + "     , B.FDNM     "
		 		   + "     , B.FDPRICE  "
	 			   + "     , B.FDOP_YN   "
			       + "     , B.TIMG    "
				   + "  FROM TB_STORE A "
				   + "     , TB_FOOD  B "
				   + " WHERE A.STONO = B.STONO "
				   + "   AND B.FDNO = " + menuMap.get("menuId")
				   + " ORDER BY A.STONO ASC, B.FDNO ";
		
		List<famFood> foods = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(famFood.class));
		
		for(int i=0; i<foods.size(); i++) {
			if(foods.get(i).getTimg() != null) {
				byte[] bt = foods.get(i).getTimg();
	            String vimg = new String( Base64.encodeBase64(bt));
	            foods.get(i).setVimg(vimg);
			}
		}		
		
		return (ArrayList<famFood>) foods;
	}
	
	@Override
	public ArrayList<famFood> get_ResFood(Map menuMap) throws Exception{				
		String sql = "SELECT A.STONO   " 
				   + "     , A.STONM    "  
				   + "     , A.STOTEL   "
				   + "     , B.FDNO     "
			 	   + "     , B.FDNM     "
		 		   + "     , Replace(Convert(Varchar, Convert(Money, B.FDPRICE),112),'.00','') AS FDPRICE  "
	 			   + "     , CASE WHEN B.FDOP_YN = 1 THEN '오픈' ELSE '미오픈' END AS FDOP_YN   "
 			       //+ "     , B.FDIMG    "
 			       + "     , B.TIMG    "
				   + "  FROM TB_STORE A "
				   + "     , TB_FOOD  B "
				   + " WHERE A.STONO = B.STONO "
				   + "   AND A.STONO = " + menuMap.get("storeId")
				   + " ORDER BY A.STONO ASC, B.FDNO ";
		List<famFood> foods = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(famFood.class));		
       
		for(int i=0; i<foods.size(); i++) {
			if(foods.get(i).getTimg() != null) {
				byte[] bt = foods.get(i).getTimg();
	            String vimg = new String( Base64.encodeBase64(bt));
	            foods.get(i).setVimg(vimg);
			}
		}
		
		return (ArrayList<famFood>) foods;
	}	
	
	@Override
	public ArrayList<famFood> get_ResFood2(Map menuMap) throws Exception {
		String sql = "SELECT A.STONO   " 
				   + "     , A.STONM    "
				   + "     , A.STOTEL   "
				   + "     , B.FDNO     "
			 	   + "     , B.FDNM     "
		 		   + "     , B.FDPRICE  "
	 			   + "     , B.FDOP_YN   "
			       + "     , B.TIMG    "
				   + "  FROM TB_STORE A "
				   + "     , TB_FOOD  B "
				   + " WHERE A.STONO = B.STONO "
				   + "   AND B.FDNO = " + menuMap.get("menuId")
				   + " ORDER BY A.STONO ASC, B.FDNO ";
		
		List<famFood> foods = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(famFood.class));
		
		for(int i=0; i<foods.size(); i++) {
			if(foods.get(i).getTimg() != null) {
				byte[] bt = foods.get(i).getTimg();
	            String vimg = new String( Base64.encodeBase64(bt));
	            foods.get(i).setVimg(vimg);
			}
		}		
		
		return (ArrayList<famFood>) foods;
	}

	@Override
	public int setStore_Ins(Map storeMap) throws Exception {
		String sql = "INSERT INTO TB_STORE(stono, stonm, stotel) VALUES ((select isnull(max(stono)+1,1) from tb_store), ?, ?)";
		jdbcTemplate.update(sql, storeMap.get("storeName")
				               , storeMap.get("storeTel"));
		
		return 0;
	}
	
	@Override
	public int setStore_Upd(Map storeMap) throws Exception {
		//String sql  = "UPDATE TB_STORE SET stonm = ?, stoopyn = ? WHERE stono = ? ";
		String sql  = "UPDATE TB_STORE SET stonm = ?, stotel = ? WHERE stono = ? ";
		jdbcTemplate.update(sql, storeMap.get("sName")
				               //, storeMap.get("sYn")
							   , storeMap.get("sTel")
				               , storeMap.get("sId"));
		
		return 0;
	}	
	
	@Override
	public int setMenu_Ins(Map MenuMap) throws Exception {
		
		String sql = "INSERT INTO TB_FOOD(fdno, fddiv, fdnm, fdprice, fdop_yn, stono, timg) VALUES "
				   + " ((select isnull(max(fdno)+1,1) from tb_food), 1, ?, ?, '1', ?, ?)";
		jdbcTemplate.update(sql, MenuMap.get("menuName")
				               , MenuMap.get("menuPrice")
				               , MenuMap.get("selectStore")
				               , MenuMap.get("menuImage"));
		
		//System.out.println("!!"+MenuMap.get("menuImage")+"!!");
		
//		String sql = "INSERT INTO TB_FOOD(fdno, fdnm, fdprice, fdopyn, stono) VALUES ((select max(fdno)+1 from tb_food), ?, ?, '1', ?)";
//		jdbcTemplate.update(sql, MenuMap.get("menuName")
//				               , MenuMap.get("menuPrice")
//				               , MenuMap.get("selectStore"));
		
		return 0;
	}
	
	@Override
	public int setMenu_Upd(Map MenuMap) throws Exception {
		String sql = "";
		
		if(!MenuMap.get("mSize").toString().equals("0")) {
			sql = "UPDATE TB_FOOD SET fdnm = ?, fdprice = ?, fdop_yn = ?, timg = ? WHERE fdno = ? ";
			jdbcTemplate.update(sql, MenuMap.get("mName")
					               , MenuMap.get("mPrice")
					               , MenuMap.get("mYn")
					               , MenuMap.get("mImage")
					               , MenuMap.get("mNo"));
		} else {
			sql = "UPDATE TB_FOOD SET fdnm = ?, fdprice = ?, fdop_yn = ? WHERE fdno = ? ";
			jdbcTemplate.update(sql, MenuMap.get("mName")
					               , MenuMap.get("mPrice")
					               , MenuMap.get("mYn")
					               , MenuMap.get("mNo"));
		}		
		
		return 0;
	}	
	
	@Override
	public int setMenu_Del(Map MenuMap) throws Exception {
		String sql = "DELETE FROM TB_FOOD WHERE fdno = ? ";
		jdbcTemplate.update(sql, MenuMap.get("mNo"));
		
		return 0;
	}
	
	@Override
	public ArrayList<famQR> getQR() throws Exception{				
		//String sql = "SELECT QR_SEQ, QR_DIV, QR_CODE, QR_IMG FROM TB_QR";
		String sql = "SELECT QRNO, DIV, URL, QIMG FROM TB_QR";
		List<famQR> qrs = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(famQR.class));		
		
		//sqrs.forEach(System.out :: println);
		
		return (ArrayList<famQR>) qrs;
	}
	
	@Override
	public int setQR_Ins(Map qrMap) throws Exception {
		//String sql = "INSERT INTO TB_QR(qr_seq, qr_div, qr_code, qr_img) VALUES ((select isnull(max(qr_seq)+1,1) from tb_qr), ?, ?, ?)";
		String sql = "INSERT INTO TB_QR(qrno, div, url, qimg) VALUES ((select isnull(max(qrno)+1,1) from tb_qr), ?, ?, ?)";
		
//		System.out.println(qrMap.get("sYn"));
//		System.out.println(qrMap.get("sUrl"));
//		System.out.println(qrMap.get("sImg"));
		
		jdbcTemplate.update(sql, qrMap.get("sYn")
				               , qrMap.get("sUrl")
				               , qrMap.get("sImg"));
		
		//System.out.println("!!"+MenuMap.get("menuImage")+"!!");
		
//		String sql = "INSERT INTO TB_FOOD(fdno, fdnm, fdprice, fdopyn, stono) VALUES ((select max(fdno)+1 from tb_food), ?, ?, '1', ?)";
//		jdbcTemplate.update(sql, MenuMap.get("menuName")
//				               , MenuMap.get("menuPrice")
//				               , MenuMap.get("selectStore"));
		
		return 0;
	}	


}
