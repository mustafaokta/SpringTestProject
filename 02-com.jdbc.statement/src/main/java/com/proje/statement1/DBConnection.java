package com.proje.statement1;

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
			logger.warn("Mysql driver bulunamadý : Hata : "+ e);
			
		}      
		
		 try {
			 connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-egitim", "root", "12345");
			logger.info("Mysql e baðlandýk..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn("Mysql e baðlanýrken hata meydana geldi.");
		} 
		return connection;
		
	}
	
	
	public static void closeConnection(Connection connection) {
		
		if(connection!=null) {
			try {
				connection.close();
				logger.info("Veritabaný baðlantýsý kapatýldý");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("Baðlantý kapanýrken hata meydana geldi, HATA : "+ e);
			}
		}	
		
	}
	
	
}
