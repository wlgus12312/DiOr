package com.dior.food.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dior.food.dto.famFood;

@Repository("MainDao")
public class MainDaoImpl implements MainDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ArrayList<famFood> getTest() throws Exception{				
		String sql = "select A.fdnm, A.fdprice, B.stonm, B.stono from tb_food A, tb_store B\r\n"
				+ "where A.stono = B.stono\r\n"
				+ "and A.fdopyn = 1 and B.stoopyn = 1";
		List<famFood> foods = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(famFood.class));		
		
//		foods.forEach(System.out :: println);
		
		return (ArrayList<famFood>) foods;
	}

}
