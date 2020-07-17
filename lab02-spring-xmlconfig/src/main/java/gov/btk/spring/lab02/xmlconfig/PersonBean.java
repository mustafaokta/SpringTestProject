package gov.btk.spring.lab02.xmlconfig;

public class PersonBean {
private String name;
private int age;
private String occupation;
private String nickName;

public PersonBean(String name, int age){
	this.age=age;
	this.name=name;
}



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}
public String getNickName() {
	return nickName;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}


}
