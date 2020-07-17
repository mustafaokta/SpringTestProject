package com.proje.delete;

import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBProcesses {
	private static final Logger logger =LogManager.getLogger();
	   
	  public static void deletePersonelbyPersonelId(int personelId) {
		  
		  String sorgu ="DELETE FROM personel WHERE personelId=?";
		  Connection connection=DBConnection.getConnection();
		  PreparedStatement preparedStatement=null;
		try {
			preparedStatement = (PreparedStatement) connection.clientPrepareStatement(sorgu);
			  preparedStatement.setInt(1, personelId);
			  logger.info(personelId+ " id li personel Silindi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn("silemedi hata : "+e);
			e.printStackTrace();
		}finally {
			DBConnection.closeConnection(connection, preparedStatement);
			
		}
	
		  
		  
	  } //method
	  
	  public static void deletePersonelByAdi(String adi) {
		  
		  String sorgu ="DELETE FROM personel WHERE adi=?";
		  Connection connection=DBConnection.getConnection();
		  PreparedStatement preparedStatement=null;
		try {
			preparedStatement = (PreparedStatement) connection.clientPrepareStatement(sorgu);
			  preparedStatement.setString(1, adi);
			  logger.info(adi+ " ad li personel Silindi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn("silemedi hata : "+e);
			e.printStackTrace();
		}finally {
			DBConnection.closeConnection(connection, preparedStatement);
			
		}
	
	  } //method
	  
	   
   }



