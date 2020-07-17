package com.proje.test;

import com.proje.db.DBConnection;
//Spring kullanmadan nesnenin oluþturulmasý normal yol
public class Test {
public static void main(String[] args) {
	DBConnection dbConnection=new DBConnection();
	dbConnection.setUrl("mysql:localhost");
	dbConnection.setUsername("okta");
	dbConnection.setPassword("1234");
	dbConnection.openConnection();
	dbConnection.closeConnection();
}
}
