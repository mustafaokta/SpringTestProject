package com.proje.insert1;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.proje.DBConnection;



public class Uygulama1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sorgu="INSERT INTO personel (personelId, adi, soyadi, dogumYili, personelNumarasi) VALUES (?,?,?,?,?)";
		Logger logger =LogManager.getLogger();
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		
		
		
		
		
	try {
		preparedStatement=(PreparedStatement)connection.clientPrepareStatement(sorgu);
		preparedStatement.setInt(1, 104);
		preparedStatement.setString(2, "Mustafa");
		preparedStatement.setString(3, "OKTA");
		preparedStatement.setInt(4, 1988);
		preparedStatement.setString(5, "22222");
		int kacverieklendi=preparedStatement.executeUpdate();
		logger.info(kacverieklendi+"   adet veri eklendi"); //i eksi1 ise veri eklenmemiþ
		
	} catch (SQLException e) {
		// TODO: handle exception
		logger.warn("Personel eklenirken hata meydana geldi"+e);
	}	finally {
		
		
		DBConnection.closeConnection(connection, preparedStatement);
	}
		
	}//main

}
