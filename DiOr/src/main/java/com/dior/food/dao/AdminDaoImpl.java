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

@Repository("AdminDao")
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ArrayList<famFood> getMenu() throws Exception{				
		String sql = "SELECT * FROM TB_STORE";
		List<famFood> foods = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(famFood.class));		
		
		//foods.forEach(System.out :: println);
		
		return (ArrayList<famFood>) foods;
	}

}
