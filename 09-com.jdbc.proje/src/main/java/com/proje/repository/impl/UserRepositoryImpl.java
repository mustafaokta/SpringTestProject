package com.proje.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.proje.connection.DBConnection;
import com.proje.model.User;
import com.proje.model.productqueries.UserQuery;
import com.proje.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private final Logger logger=LogManager.getLogger();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	
	
	//INSERT INTO user(userId, firstName, lastName, birthOfDate, useName) VALUES (?,?,?,?,?)";
	@Override
	public User saveUser(User user) {
		connection=DBConnection.getConnection();
		try {
			preparedStatement= (PreparedStatement) connection.prepareStatement(UserQuery.saveUserQuery);
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setDate(4, user.getBirthOfDate());
			preparedStatement.setString(5, user.getUseName());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn(user.getUserId()+" idli User kaydedilirken hata:  "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);					
		}		
		
		return user;
	} //methodsonu
	
	public boolean saveUserProduct(int userId, int productId){
		//"INSERT INTO user_product (userId, productId) VALUES (?,?)";
		connection=DBConnection.getConnection();
		try {
			preparedStatement= (PreparedStatement) connection.prepareStatement(UserQuery.saveUser_ProductQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, productId);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn(" User Product kaydedilirken hata:  "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);					
		}		
		
		
	return true;	
	}
	
	
	
	
	
}
