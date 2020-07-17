package com.proje.update;

import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBProcesses {
	private static final Logger logger =LogManager.getLogger();
	   
	  public static Personel updatePersonel(Personel personel) {
		  String sorgu ="UPDATE personel SET adi=?, soyadi=?, dogumYili=?, personelNumarasi=? WHERE personelId=?";
		  Connection connection = DBConnection.getConnection();
		  
		  PreparedStatement preparedStatement=null;
		  
		  try {
			preparedStatement=(PreparedStatement) connection.prepareStatement(sorgu);
			
			
				
				preparedStatement.setString(1, personel.getAdi());
				preparedStatement.setString(2, personel.getSoyadi());
				preparedStatement.setInt(3, personel.getDogumYili());
				preparedStatement.setString(4, personel.getPersonelNumarasi());
				preparedStatement.setInt(5, personel.getPersonelId());
				preparedStatement.executeUpdate();
			
			logger.info(personel.getPersonelId()+"  id li personel bilgileri güncellendi");
			
						
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn(personel.getPersonelId()+"Personel idli kiþi eklenirken hata meydana geldi hata: "+e);
			
			
		}
		  finally {
			  DBConnection.closeConnection(connection, preparedStatement);
			  
			  
		  }
		  return personel;
	  } //method
	  
	   
	   
   }



