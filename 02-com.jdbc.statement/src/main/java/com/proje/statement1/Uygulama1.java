package com.proje.statement1;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Uygulama1 {

	
	
	public static void main(String[] args) {
		Logger logger=LogManager.getLogger();
		Connection connection=DBConnection.getConnection();
	Statement statement=null;
	try {
		statement =(Statement) connection.createStatement();
		String sorgu="CREATE TABLE personel(personelId INT PRIMARY KEY NOT NULL, adi VARCHAR(255), soyadi VARCHAR(255), dogumYili INT, personelNumarasi VARCHAR(20))";
	statement.execute(sorgu);
	logger.info("Personel tablosu ba�ar�l� bir �ekilde olu�turuldu. ");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.warn("Personel tablosu olu�uturulurken bir hata meydana geldi, hata :  " +e);
		
	}
	finally {
		if(statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("ba�lant� sonland�rma hatas� olu�tu");
			}
			
			
			
		}
		
		DBConnection.closeConnection(connection);
		
		
	}
	}
}
