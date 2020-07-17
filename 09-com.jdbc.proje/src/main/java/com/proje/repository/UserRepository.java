package com.proje.repository;

import com.proje.model.User;

public interface UserRepository{
User saveUser(User user);
boolean saveUserProduct(int userId, int productId);
}