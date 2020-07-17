package com.proje.test;


import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.db.DBConnection;
//applicationContext.xml dosyas� ile yapmak i�in yap�lan test
public class TestSpring {
	public static void main(String[] args) {
			
		//d�rd�nc�y�ntem
		ConfigurableApplicationContext configurableApplicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		DBConnection dbConnection = (DBConnection) configurableApplicationContext.getBean("dbConnection");
		dbConnection.openConnection();
		dbConnection.closeConnection();
		configurableApplicationContext.close();
		//*d�rd�nc�y�ntemsonu
		
		
		
	}

}
