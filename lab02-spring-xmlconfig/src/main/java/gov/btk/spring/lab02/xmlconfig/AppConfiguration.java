package gov.btk.spring.lab02.xmlconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="gov.btk.spring")
@PropertySource(value="application.properties")
public class AppConfiguration {
	
	
	@Value("${person.occupation}")
	String occupation;
	
	@Bean(name = "anOtherBean")
	public PersonBean personBean() {
		PersonBean personBean = new PersonBean("Workshop-hero", 24);
		personBean.setNickName("wh");
		personBean.setOccupation(occupation);
		return personBean;
		
	}
	
	
	
	
}
