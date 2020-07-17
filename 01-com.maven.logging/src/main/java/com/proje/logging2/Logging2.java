package com.proje.logging2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging2 {
private static Logger logger=LogManager.getLogger();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		insertPersonel("Ali");
		
	}
public static void insertPersonel(String adi) {
	logger.info(adi+"adlý personel kaydedilmiþtir");
}
}
