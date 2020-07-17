package com.proje.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proje.db.DBConnection;

@Configuration
public class AppConfig {
	
	@Bean
	public DBConnection dbConnectionMethod() {
		DBConnection dbConnection=new DBConnection();
		dbConnection.setUrl("mysql:localhost");
		dbConnection.setUsername("okta");
		dbConnection.setPassword("123456");
		
		
		return dbConnection;
		
	}
	

}
