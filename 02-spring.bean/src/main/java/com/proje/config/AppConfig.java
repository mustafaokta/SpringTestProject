package com.proje.config;
//Anotasyon ile bean olu�turma �rne�i
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proje.db.DBConnection;

@Configuration
public class AppConfig {
	
@Bean	
public DBConnection dbConnectionMethod() {
	
	 DBConnection dbConnection=new  DBConnection();
	
	return dbConnection;
}
}
