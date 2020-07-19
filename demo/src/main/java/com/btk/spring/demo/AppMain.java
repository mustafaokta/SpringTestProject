package com.btk.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;
@SpringBootApplication
public class AppMain implements CommandLineRunner{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SpringApplication.run(AppMain.class);
		System.out.println("Hello world");
		//ApplicationContext appContext;
	}
@Autowired
JdbcTemplate jdbcTemplate;
@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	Assert.notNull(jdbcTemplate, "App-context sorunlu, jdbc template mevcut deðil");
}
}
