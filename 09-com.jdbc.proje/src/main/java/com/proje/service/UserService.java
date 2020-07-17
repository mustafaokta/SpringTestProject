package com.proje.service;

import com.proje.model.User;

public interface UserService {
	User saveUser(User user);
	boolean saveUserProduct(int userId, int productId);
}
