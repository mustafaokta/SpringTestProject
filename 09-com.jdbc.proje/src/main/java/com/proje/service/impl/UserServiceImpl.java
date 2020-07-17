package com.proje.service.impl;

import com.proje.model.User;
import com.proje.repository.UserRepository;
import com.proje.repository.impl.UserRepositoryImpl;
import com.proje.service.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository=new UserRepositoryImpl();
	
	@Override
	public User saveUser(User user) {
		User u=userRepository.saveUser(user);
		
		
		
		return u;
			
	}
	@Override
	public boolean saveUserProduct(int userId, int productId) {
		return userRepository.saveUserProduct(userId, productId);
		
	}
	
}
