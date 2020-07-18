package gov.btk.spring.lab02.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class AppMain {

	private static ApplicationContext appContext;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//appContext = new ClassPathXmlApplicationContext("app-context.xml");
		appContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		// assert singleton bean
		assertSingleton();
		
		// assert prototype bean
		assertPrototype();
		
		// assert dependency injection
		assertDependencyInjection();
		
		// assert person bean
		assertPersonBean();
	}

	private static void assertPrototype() {
		PrototypeBean prototypeBean1 = appContext.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMessage());
		
		PrototypeBean prototypeBean2 = appContext.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMessage());
		
		PrototypeBean prototypeBean3 = appContext.getBean(PrototypeBean.class);
		System.out.println(prototypeBean3.getMessage());
		
		Assert.isTrue(prototypeBean1 != prototypeBean2, "prototype bean does not work!!!");
		Assert.isTrue(prototypeBean1 != prototypeBean3, "prototype bean does not work!!!");
	}

	private static void assertSingleton() {
		SingletonBean singletonBean1 = appContext.getBean("xxxBean", SingletonBean.class);
		System.out.println(singletonBean1.getMessage());
		
		SingletonBean singletonBean2 = appContext.getBean("xxxBean", SingletonBean.class);
		System.out.println(singletonBean2.getMessage());
		
		SingletonBean singletonBean3 = appContext.getBean("xxxBean", SingletonBean.class);
		System.out.println(singletonBean3.getMessage());

		Assert.isTrue(singletonBean1 == singletonBean2, "singleton bean does not work!!!");
		Assert.isTrue(singletonBean1 == singletonBean3, "singleton bean does not work!!!");
	}
	
	private static void assertDependencyInjection() {
		ServiceBean serviceBean = appContext.getBean(ServiceBean.class);
		System.out.println(serviceBean.getMessage());
		
		Assert.isTrue(serviceBean.getSingletonBean() != null, "singleton bean is not set in Service Bean!!!");
		Assert.isTrue(serviceBean.getPrototypeBean() != null, "prototype bean is not set in Service Bean!!!");
	}

	private static void assertPersonBean() {
		PersonBean personBean = appContext.getBean("anOtherBean", PersonBean.class);
		System.out.println(personBean.getName() + " : " + personBean.getAge());
		
		Assert.isTrue(personBean.getAge() == 24, "age property does not work !!!");
		Assert.isTrue(personBean.getName().equals("Workshop-hero"), "name property does not work !!!");
		Assert.isTrue(personBean.getOccupation().equals("Engineer"), "occupation property does not work !!!");
		Assert.isTrue(personBean.getNickName().equals("wh"), "nick-name property does not work !!!");
	}

	
}
