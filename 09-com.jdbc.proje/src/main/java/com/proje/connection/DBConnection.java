package com.proje.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class DBConnection {

	private static final Logger logger=LogManager.getLogger();
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;

	
	static {
		Properties properties=new Properties(); //bir properties nesnesi yarat�p okudugumuz dosyay� onun i�ine at�yoruz
		
		try {
			InputStream inputStream=new FileInputStream("src/main/resources/database.properties");
			properties.load(inputStream);
			driver=properties.getProperty("db_driver");
			url=properties.getProperty("db_url");
			user=properties.getProperty("db_user");
			password=properties.getProperty("db_password");
			
			
		} catch (IOException e) {
			logger.warn("database.properties dosyas� okunurken hata meydana geldi hata:  "+e);
		}
	}
	public static Connection getConnection(){

		
	Connection connection=null;
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		logger.warn("Driver y�klenirken hata :"+e);
	}
	try {
		connection=(Connection)DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.warn("database driver manager ba�lant� hatas� hata :"+e);
	}
	
	
	
	return connection;
	
	}

	public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultset) {
		if(resultset!=null) {
			try {
				resultset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("ResultSet kapat�l�rken hata olu�tu hata: "+e);
			}
			
		}
		
		
		
		if(preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("preparedStatement ba�lant� sonland�rma hatas� olu�tu");
			}
			
			
			
		}
	
		if(connection!=null) {
			try {
				connection.close();
				logger.info("Veritaban� ba�lant�s� kapat�ld�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("Ba�lant� kapan�rken hata meydana geldi, HATA : "+ e);
			}
		}	
		
	}
	



}
