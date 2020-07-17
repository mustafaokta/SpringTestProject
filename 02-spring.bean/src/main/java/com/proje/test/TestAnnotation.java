package com.proje.test;
//AppConfig dosyas� ile birlikte bean i method yolu ile olu�turuyoruz

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proje.config.AppConfig;
import com.proje.db.DBConnection;

public class TestAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext configurableApplicationContext = new AnnotationConfigApplicationContext(
				AppConfig.class);
		DBConnection dbConnection =configurableApplicationContext.getBean(DBConnection.class);
		//bean ismi olmad��� i�in "DBConnection.class" ifadesi o beane i�aret ediyor
		dbConnection.openConnection();
		dbConnection.closeConnection();
		
		
		
		
		configurableApplicationContext.close();
	}

}
