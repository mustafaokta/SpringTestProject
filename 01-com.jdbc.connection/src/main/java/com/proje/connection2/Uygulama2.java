package com.proje.connection2;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;

public class Uygulama2 {
    private static Connection connection=null;
    private static final Logger logger=LogManager.getLogger();
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  openConnection();
  closeConnection();
		
		
		
		
		
	}
	
	private static void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //mysqliimzi aktif edyoruz
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.warn("Mysql driver bulunamadı : Hata : "+ e);
			return;
		}      
		
		 try {
			 connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-egitim", "root", "12345");
			logger.info("Mysql e bağlandık..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn("Mysql e bağlanırken hata meydana geldi.");
		} 
		
		
	}
	private static void closeConnection() {
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
