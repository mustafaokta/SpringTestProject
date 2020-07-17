package com.proje.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
public static void main(String[] args) {
	
	Logger logger=LogManager.getLogger();
	logger.trace("trace log");
	logger.debug("debug log");
	logger.info("Ýnfo log");
	logger.warn("warn log");
	logger.error("error log");
	logger.fatal("fatal log");
	
	
	
	
	
}
}
