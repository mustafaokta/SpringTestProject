package com.proje.connection1;


import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;



public class Uygulama1 {
public static void main(String[] args) {
	Logger logger=LogManager.getLogger(); //loggerýmýzý aktif ediyoruz ilk olarak
	try {
		Class.forName("com.mysql.jdbc.Driver"); //mysqliimzi aktif edyoruz
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		logger.warn("Mysql driver bulunamadý : Hata : "+ e);
		return;
	}      
	Connection connection=null;
	 try {
		 connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-egitim", "root", "12345");
		logger.info("Mysql e baðlandýk..");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.warn("Mysql e baðlanýrken hata meydana geldi.");
	} finally {
		if(connection!=null) {
			try {
				connection.close();
				logger.info("Baðlantý baþarýlý bir þekilde sonlandýrýldý...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("Baðlantý kapanýrken hata meydana geldi");
			}
		}
	}
	
}
}
