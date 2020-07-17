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
		Properties properties=new Properties(); //bir properties nesnesi yaratýp okudugumuz dosyayý onun içine atýyoruz
		
		try {
			InputStream inputStream=new FileInputStream("src/main/resources/database.properties");
			properties.load(inputStream);
			driver=properties.getProperty("db_driver");
			url=properties.getProperty("db_url");
			user=properties.getProperty("db_user");
			password=properties.getProperty("db_password");
			
			
		} catch (IOException e) {
			logger.warn("database.properties dosyasý okunurken hata meydana geldi hata:  "+e);
		}
	}
	public static Connection getConnection(){

		
	Connection connection=null;
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		logger.warn("Driver yüklenirken hata :"+e);
	}
	try {
		connection=(Connection)DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.warn("database driver manager baðlantý hatasý hata :"+e);
	}
	
	
	
	return connection;
	
	}

	public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultset) {
		if(resultset!=null) {
			try {
				resultset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("ResultSet kapatýlýrken hata oluþtu hata: "+e);
			}
			
		}
		
		
		
		if(preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("preparedStatement baðlantý sonlandýrma hatasý oluþtu");
			}
			
			
			
		}
	
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
