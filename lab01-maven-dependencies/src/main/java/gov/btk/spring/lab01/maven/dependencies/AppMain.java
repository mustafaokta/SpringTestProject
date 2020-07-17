package gov.btk.spring.lab01.maven.dependencies;

import org.joda.time.LocalTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);

		// the purpose is just to import the class and reference it without compilation errors
		ApplicationContext appContext = new ClassPathXmlApplicationContext("app-context.xml");
		
		ServiceBean serviceBean =appContext.getBean(ServiceBean.class) ;//tipi servis bean olaný ver
		
		ActualBusinessComponent actualBusinessComponent = new ActualBusinessComponent();
		
		serviceBean.setActualBusinessComponent(actualBusinessComponent);
		
		System.out.println(serviceBean.getMessage());
	}
}
