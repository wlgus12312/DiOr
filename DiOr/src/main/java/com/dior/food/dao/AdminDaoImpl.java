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
	public ArrayList<famFood> getFood() throws Exception{				
		String sql = "SELECT A.STONO   " 
				   + "     , A.STONM    " 
				   + "     , A.STOOPYN  " 
				   + "     , B.FDNO     "
			 	   + "     , B.FDNM     "
		 		   + "     , Replace(Convert(Varchar, Convert(Money, B.FDPRICE),112),'.00','') AS FDPRICE  "
	 			   + "     , CASE WHEN B.FDOPYN = 1 THEN '오픈' ELSE '미오픈' END AS FDOPYN   "
 			       //+ "     , B.FDIMG    "
 			      + "     , B.TIMG    "
				   + "  FROM TB_STORE A "
				   + "     , TB_FOOD  B "
				   + " WHERE A.STONO = B.STONO "
				   //+ "   AND A.STOOPYN = '1' "
				   + " ORDER BY A.STOOPYN DESC, A.STONO ASC, B.FDNO ";
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
				   + "     , A.STOOPYN  " 
				   + "     , B.FDNO     "
			 	   + "     , B.FDNM     "
		 		   + "     , B.FDPRICE  "
	 			   + "     , B.FDOPYN   "
			       + "     , B.TIMG    "
				   + "  FROM TB_STORE A "
				   + "     , TB_FOOD  B "
				   + " WHERE A.STONO = B.STONO "
				   //+ "   AND A.STOOPYN = '1' "
				   + "   AND B.FDNO = " + menuMap.get("menuId")
				   + " ORDER BY A.STOOPYN DESC, A.STONO ASC, B.FDNO ";
		
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
		String sql = "INSERT INTO TB_STORE(stono, stonm, stoopyn) VALUES ((select max(stono)+1 from tb_store), ?, '1')";
		jdbcTemplate.update(sql, storeMap.get("storeName"));
		
		return 0;
	}
	
	@Override
	public int setStore_Upd(Map storeMap) throws Exception {
		String sql  = "UPDATE TB_STORE SET stonm = ?, stoopyn = ? WHERE stono = ? ";
		jdbcTemplate.update(sql, storeMap.get("sName")
				               , storeMap.get("sYn")
				               , storeMap.get("sId"));
		
		return 0;
	}	
	
	@Override
	public int setMenu_Ins(Map MenuMap) throws Exception {
		
		String sql = "INSERT INTO TB_FOOD(fdno, fdnm, fdprice, fdopyn, stono, timg) VALUES ((select max(fdno)+1 from tb_food), ?, ?, '1', ?, ?)";
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
		String sql = "UPDATE TB_FOOD SET fdnm = ?, fdprice = ?, fdopyn = ?, timg = ? WHERE fdno = ? ";
		jdbcTemplate.update(sql, MenuMap.get("mName")
				               , MenuMap.get("mPrice")
				               , MenuMap.get("mYn")
				               , MenuMap.get("mImage")
				               , MenuMap.get("mNo"));
		
		return 0;
	}	
	
	@Override
	public int setMenu_Del(Map MenuMap) throws Exception {
		String sql = "DELETE FROM TB_FOOD WHERE fdno = ? ";
		jdbcTemplate.update(sql, MenuMap.get("mNo"));
		
		return 0;
	}		


}
