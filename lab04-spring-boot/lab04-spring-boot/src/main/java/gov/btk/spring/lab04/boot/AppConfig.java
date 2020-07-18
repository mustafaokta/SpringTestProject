package gov.btk.spring.lab04.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	// TODO - fetch person properties from application.properties 
	
	@Bean(name="anOtherBean")
	public PersonBean personBean() {
		PersonBean personBean = new PersonBean(age, name);
		personBean.setOccupation(occupation);
		personBean.setNickName(nickName);
		return personBean;
	}
	
}
