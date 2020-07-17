package com.proje.statement2;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Uygulama2 {

	
	
	public static void main(String[] args) {
		createPersonelTable();
		
	}




public static void createPersonelTable() {
	
	Logger logger=LogManager.getLogger();
	Connection connection=DBConnection.getConnection();
Statement statement=null;
try {
	statement =(Statement) connection.createStatement();
	String sorgu="CREATE TABLE personel(personelId INT PRIMARY KEY NOT NULL, adi VARCHAR(255), soyadi VARCHAR(255), dogumYili INT, personelNumarasi VARCHAR(20))";
statement.execute(sorgu);
logger.info("Personel tablosu baþarýlý bir þekilde oluþturuldu. ");
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	logger.warn("Personel tablosu oluþuturulurken bir hata meydana geldi, hata :  " +e);
	
}
finally {
	
	
	DBConnection.closeConnection(connection,statement);
	
	
}
}




}
