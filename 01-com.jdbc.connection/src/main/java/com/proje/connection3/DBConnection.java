package com.proje.connection3;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;

public class DBConnection {

	private static final Logger logger=LogManager.getLogger();
	
	
	
	public static Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //mysqliimzi aktif edyoruz
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.warn("Mysql driver bulunamadı : Hata : "+ e);
			
		}      
		
		 try {
			 connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-egitim", "root", "12345");
			logger.info("Mysql e bağlandık..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn("Mysql e bağlanırken hata meydana geldi.");
		} 
		return connection;
		
	}
	
	
	public static void closeConnection(Connection connection) {
		
		if(connection!=null) {
			try {
				connection.close();
				logger.info("Veritabanı bağlantısı kapatıldı");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("Bağlantı kapanırken hata meydana geldi, HATA : "+ e);
			}
		}	
		
	}
	
	
}
