package com.stewartlavenia.tally2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import com.stewartlavenia.tally2.CalCalcDao;
import com.stewartlavenia.tally2.entity.Users;

class Tally2Test {

	private CalCalcDao dao;
	
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/tallyCalCarbsDaily");
		datasource.setUsername("calCalc");
		datasource.setPassword("calCalc");
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	
		dao = new CalCalcDao(new JdbcTemplate(datasource));
	}
	

	@AfterEach
	void tearDownAfterClass() throws Exception {
	}

	@Test
	void testList() {
		List<Users> listUsers = dao.list();
		assertFalse(listUsers.isEmpty());
		System.out.println(dao.list());
	}
	
	@Test
	void testSave() {
		Users user = new Users(23, "Boogie", "Jones", "BoogieJones@yahoo.com", "818-893-4554");
		dao.save(user);
	}

}
