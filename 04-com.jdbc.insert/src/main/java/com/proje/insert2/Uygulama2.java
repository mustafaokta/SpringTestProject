package com.proje.insert2;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.proje.DBConnection;

public class Uygulama2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		savePersonel(108,"Utku", "OKTA", 2018, "1905");
		
		savePersonel(109,"Sahra", "OKTA", 2018, "1905");
		
		
	}
	
	
	public static void savePersonel(int personelId, String adi, String soyadi, int dogumYili, String personelNumarasi) {
		
		String sorgu="INSERT INTO personel (personelId, adi, soyadi, dogumYili, personelNumarasi) VALUES (?,?,?,?,?)";
		Logger logger =LogManager.getLogger();
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		
		
		
		
		
	try {
		preparedStatement=(PreparedStatement)connection.clientPrepareStatement(sorgu);
		preparedStatement.setInt(1, personelId);
		preparedStatement.setString(2, adi);
		preparedStatement.setString(3, soyadi);
		preparedStatement.setInt(4, dogumYili);
		preparedStatement.setString(5, personelNumarasi);
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
