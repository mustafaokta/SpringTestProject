package com.proje.insert3;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.proje.DBConnection;

public class Uygulama3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Personel personel1=new Personel(110, "Radamel", "Falcao", 1988, "1905");
		savePersonel(personel1);
		
		//savePersonel(108,"Utku", "OKTA", 2018, "1905");
		
	//	savePersonel(109,"Sahra", "OKTA", 2018, "1905");
		
		
	}
	
	
	public static void savePersonel(Personel personel) {
		
		String sorgu="INSERT INTO personel (personelId, adi, soyadi, dogumYili, personelNumarasi) VALUES (?,?,?,?,?)";
		Logger logger =LogManager.getLogger();
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
