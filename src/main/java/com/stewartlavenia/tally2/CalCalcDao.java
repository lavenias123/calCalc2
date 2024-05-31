package com.stewartlavenia.tally2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import com.stewartlavenia.tally2.entity.*;


@Repository
public class CalCalcDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CalCalcDao (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Users> list() {
		String sql = "SELECT * FROM users";
		
		// represents DB info without result set?
		List<Users> listUsers = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Users.class));
//		System.out.println(sql);
		return listUsers;
	}
		// to insert new row
	public void save(Users user) {
		
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("users").usingColumns("firstName", "lastName", "email", "phone");
		// .usingGeneratedKeyColumns("user_id"); 
		
		// for inserting into DB
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
		insertActor.execute(param);
		
	}
	
}
