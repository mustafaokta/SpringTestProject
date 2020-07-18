package gov.btk.spring.lab04.boot;

import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppMain {

	private static ApplicationContext appContext;

	public static void main(String[] args) {
		appContext = SpringApplication.run(AppMain.class);
		
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
		SingletonBean singletonBean1 = appContext.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMessage());
		
		SingletonBean singletonBean2 = appContext.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMessage());
		
		SingletonBean singletonBean3 = appContext.getBean(SingletonBean.class);
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
		
		Assert.isTrue(personBean.getAge() == 20, "age property does not work !!!");
		Assert.isTrue(personBean.getName().equals("app-property"), "name property does not work !!!");
		Assert.isTrue(personBean.getOccupation().equals("Writer"), "occupation property does not work !!!");
		Assert.isTrue(personBean.getNickName().equals("foo"), "nick-name property does not work !!!");
	}

	
}
