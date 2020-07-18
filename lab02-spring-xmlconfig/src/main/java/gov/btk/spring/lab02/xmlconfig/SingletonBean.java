package gov.btk.spring.lab02.xmlconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="xxxBean")

public class SingletonBean {

	public String getMessage() {
		return "Hello there, I am a SINGLETON bean. " + this.toString();
	}
}
