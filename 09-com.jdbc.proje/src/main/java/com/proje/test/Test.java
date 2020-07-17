package com.proje.test;


import java.sql.Date;

import com.proje.model.User;
import com.proje.service.UserService;
import com.proje.service.impl.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			UserService userService=new UserServiceImpl();
			User user =new User(1027, "Selman", "Arslan", new Date(new java.util.Date().getTime()), "sarslan");
			userService.saveUser(user);
			//userService.saveUserProduct(1023, 99);
			}

}
