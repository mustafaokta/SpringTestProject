package com.proje.model;

import java.sql.Date;
import java.util.List;

public class User {
private int userId;
private String firstName;
private String lastName;
private Date birthOfDate;
private String useName;
private List <Product>products;

public User() {}
public User(int userId, String firstName, String lastName, Date birthOfDate, String useName) {

	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.birthOfDate = birthOfDate;
	this.useName = useName;

}
public User(int userId, String firstName, String lastName, Date birthOfDate, String useName, List<Product> products) {

	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.birthOfDate = birthOfDate;
	this.useName = useName;
	this.products = products;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Date getBirthOfDate() {
	return birthOfDate;
}

public void setBirthOfDate(Date birthOfDate) {
	this.birthOfDate = birthOfDate;
}

public String getUseName() {
	return useName;
}

public void setUseName(String useName) {
	this.useName = useName;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", birthOfDate="
			+ birthOfDate + ", useName=" + useName + "]";
}


}
