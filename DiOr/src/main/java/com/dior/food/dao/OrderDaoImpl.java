package com.dior.food.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dior.food.config.OrMassage;
import com.dior.food.dto.menuDto;

@Repository("OrderDao")
public class OrderDaoImpl implements OrderDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public OrMassage selectOrderList(int i) throws Exception {
		String sql = "select A.ordno                       \r\n"
				+ "     , A.fdno                           \r\n"
				+ "	 , A.ordcnt                            \r\n"
				+ "	 , A.ordstsc                           \r\n"
				+ "	 , A.ords                              \r\n"
				+ "	 , B.fdnm                              \r\n"
				+ "  from tb_order A,                      \r\n"
				+ "       tb_food  B                       \r\n"
				+ " where A.fdno  = B.fdno                 \r\n"
				+ "   and B.stono = '1'                    \r\n"
				+ "   and A.ordno = (select MAX(A.ordno)   \r\n"
				+ "				    from tb_order A,       \r\n"
				+ "					     tb_food  B        \r\n"
				+ "				   where A.fdno = B.fdno   \r\n"
				+ "				     and B.stono = '1')";
		OrMassage massage = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(OrMassage.class));		
		
		return massage;
	}
	
}
