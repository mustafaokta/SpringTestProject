package com.proje.connection1;


import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;



public class Uygulama1 {
public static void main(String[] args) {
	Logger logger=LogManager.getLogger(); //logger�m�z� aktif ediyoruz ilk olarak
	try {
		Class.forName("com.mysql.jdbc.Driver"); //mysqliimzi aktif edyoruz
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		logger.warn("Mysql driver bulunamad� : Hata : "+ e);
		return;
	}      
	Connection connection=null;
	 try {
		 connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-egitim", "root", "12345");
		logger.info("Mysql e ba�land�k..");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.warn("Mysql e ba�lan�rken hata meydana geldi.");
	} finally {
		if(connection!=null) {
			try {
				connection.close();
				logger.info("Ba�lant� ba�ar�l� bir �ekilde sonland�r�ld�...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("Ba�lant� kapan�rken hata meydana geldi");
			}
		}
	}
	
}
}
