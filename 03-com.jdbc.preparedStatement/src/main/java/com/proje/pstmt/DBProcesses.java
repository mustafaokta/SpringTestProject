package com.proje.pstmt;


import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;



public class DBProcesses {
	
	private final Logger logger=LogManager.getLogger();
	
	
	
	
	
	public void createPersonelTable() {
		
		
		Connection connection=DBConnection.getConnection();
	PreparedStatement preparedStatement=null;
	String sorgu="CREATE TABLE personel(personelId INT PRIMARY KEY NOT NULL, adi VARCHAR(255), soyadi VARCHAR(255), dogumYili INT, personelNumarasi VARCHAR(20))";
	try {
		preparedStatement =(PreparedStatement) connection.prepareStatement(sorgu);
		
		preparedStatement.execute();
	logger.info("Personel tablosu baþarýlý bir þekilde oluþturuldu. ");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.warn("Personel tablosu oluþuturulurken bir hata meydana geldi, hata :  " +e);
		
	}
	finally {
		
		
		DBConnection.closeConnection(connection,preparedStatement);
		
		
	}
	} //method sonu

}
