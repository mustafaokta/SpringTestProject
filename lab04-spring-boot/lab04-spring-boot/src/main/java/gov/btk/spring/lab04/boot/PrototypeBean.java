package gov.btk.spring.lab04.boot;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class PrototypeBean {

	public String getMessage() {
		return "Hello there, I am a PROTOTYPE bean. " + this.toString();
	}
}
