package com.proje.search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBProcesses {
	private static final Logger logger =LogManager.getLogger();
	   
	  public static Personel findPersonelbyId(int id) {
		  
		  String sorgu ="SELECT * FROM personel WHERE personelId=?";
		  Connection connection=DBConnection.getConnection();
		  ResultSet resultset =null; 
		  
		  PreparedStatement preparedStatement=null;
		  Personel personel=null;
		
			try {
				preparedStatement = (PreparedStatement) connection.clientPrepareStatement(sorgu);
				 preparedStatement.setInt(1, id);
				  resultset=preparedStatement.executeQuery();
				if(resultset.next()) {
					int personelId=resultset.getInt(1);
					String adi=resultset.getString(2);
					String soyadi=resultset.getString(3);
					int dogumYili=resultset.getInt("dogumYili"); //column ismi ile de olabiliyo numarasý ile de
					String personelNumarasi=resultset.getString(5);
					personel=new Personel(personelId,adi,soyadi,dogumYili,personelNumarasi);
					
					
				}
				
			} catch (SQLException e) {
			logger.warn(id + " id li personel bulunamadý");
			}
			 finally {
			
			
			DBConnection.closeConnection(connection, preparedStatement, resultset);
			 }
		
		  
		  return personel;
	  } //method
	  
	  public static List<Personel>findPersonels(){
		  String sorgu ="SELECT * FROM personel";
		  Connection connection=DBConnection.getConnection();
		  ResultSet resultset =null; 
		  
		  PreparedStatement preparedStatement=null;
		 List<Personel>personels=new ArrayList<Personel>();
		
			try {
				preparedStatement = (PreparedStatement) connection.clientPrepareStatement(sorgu);
				 
				  resultset=preparedStatement.executeQuery();
				while(resultset.next()) {
					int personelId=resultset.getInt(1);
					String adi=resultset.getString(2);
					String soyadi=resultset.getString(3);
					int dogumYili=resultset.getInt("dogumYili"); //column ismi ile de olabiliyo numarasý ile de
					String personelNumarasi=resultset.getString(5);
				Personel personel=new Personel(personelId,adi,soyadi,dogumYili,personelNumarasi);
					personels.add(personel);
					
				}
				
			} catch (SQLException e) {
			logger.warn( "Personel listesi alýnýrken bir hata meydana geldi hata : "+e);
			}
			 finally {
			
			
			DBConnection.closeConnection(connection, preparedStatement, resultset);
			 }
		
		  
		  
		  return personels;
	  }
	  
	   
   }



