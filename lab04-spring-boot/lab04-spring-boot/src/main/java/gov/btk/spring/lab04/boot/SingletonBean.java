package gov.btk.spring.lab04.boot;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class SingletonBean {

	public String getMessage() {
		return "Hello there, I am a SINGLETON bean. " + this.toString();
	}
}
