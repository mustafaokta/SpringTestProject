package com.proje.insert4;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.proje.DBConnection;

public class DBProcesses {
private static final Logger logger =LogManager.getLogger();
public static void savePersonel(Personel personel) {
		
		String sorgu="INSERT INTO personel (personelId, adi, soyadi, dogumYili, personelNumarasi) VALUES (?,?,?,?,?)";
		
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		
		
		
		
		
	try {
		preparedStatement=(PreparedStatement)connection.clientPrepareStatement(sorgu);
		preparedStatement.setInt(1, personel.getPersonelId());
		preparedStatement.setString(2, personel.getAdi());
		preparedStatement.setString(3, personel.getSoyadi());
		preparedStatement.setInt(4, personel.getDogumYili());
		preparedStatement.setString(5, personel.getPersonelNumarasi());
		int kacverieklendi=preparedStatement.executeUpdate();
		logger.info(kacverieklendi+"   adet veri eklendi"); //i eksi1 ise veri eklenmemiþ
		
	} catch (SQLException e) {
		// TODO: handle exception
		logger.warn("Personel eklenirken hata meydana geldi"+e);
	}	finally {
		
		
		DBConnection.closeConnection(connection, preparedStatement);
	}
		
		
		
	}//method
	
	
}
