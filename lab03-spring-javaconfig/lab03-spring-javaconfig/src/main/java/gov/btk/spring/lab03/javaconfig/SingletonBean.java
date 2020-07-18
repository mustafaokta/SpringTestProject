package gov.btk.spring.lab03.javaconfig;


public class SingletonBean {

	public String getMessage() {
		return "Hello there, I am a SINGLETON bean. " + this.toString();
	}
}
