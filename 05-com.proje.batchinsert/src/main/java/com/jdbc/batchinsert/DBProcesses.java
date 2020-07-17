package com.jdbc.batchinsert;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBProcesses {
	private static final Logger logger =LogManager.getLogger();
	   
	  public static void savePersonelList(List<Personel>personels) {
		  String sorgu ="INSERT INTO personel (personelId, adi, soyadi,dogumYili, personelNumarasi) VALUES (?,?,?,?,?)";
		  Connection connection = DBConnection.getConnection();
		  
		  PreparedStatement preparedStatement=null;
		  
		  try {
			preparedStatement=(PreparedStatement) connection.prepareStatement(sorgu);
			
			for(Personel personel:personels) {
				preparedStatement.setInt(1, personel.getPersonelId());
				preparedStatement.setString(2, personel.getAdi());
				preparedStatement.setString(3, personel.getSoyadi());
				preparedStatement.setInt(4, personel.getDogumYili());
				preparedStatement.setString(5, personel.getPersonelNumarasi());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			
					
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn("Personel Listesi eklenirken hata meydana geldi hata: "+e);
			
			
		}
		  finally {
			  DBConnection.closeConnection(connection, preparedStatement);	
		  }
	  } 
	   
	   
   }



