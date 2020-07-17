package com.proje.test;
//AppConfig dosyasý ile birlikte bean i method yolu ile oluþturuyoruz

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.proje.config.AppConfig;
import com.proje.db.DBConnection;

public class TestAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		DBConnection dbConnection =applicationContext.getBean(DBConnection.class);
		dbConnection.openConnection();
		dbConnection.closeConnection();
		
		applicationContext.close();
	}

}
