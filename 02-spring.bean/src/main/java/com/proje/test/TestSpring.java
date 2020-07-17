package com.proje.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.db.DBConnection;

public class TestSpring {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");

		DBConnection dbConnection = (DBConnection) beanFactory.getBean("dbConnection");
		dbConnection.openConnection();
		dbConnection.closeConnection();

		// ikinci y�ntem bean olu�turmada
		AbstractApplicationContext abstractApplicaticationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		DBConnection dbConnection2 = abstractApplicaticationContext.getBean("dbConnection", DBConnection.class);
		dbConnection2.openConnection();
		dbConnection2.closeConnection();
		abstractApplicaticationContext.close();
		//*ikinciy�ntemsonu
		//���nc� y�ntem
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DBConnection dbConnection3 = (DBConnection) applicationContext.getBean("dbConnection");
		dbConnection3.openConnection();
		dbConnection3.closeConnection();
		//*���nc�y�ntemsonu
		//d�rd�nc�y�ntem
		ConfigurableApplicationContext configurableApplicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		DBConnection dbConnection4 = (DBConnection) configurableApplicationContext.getBean("dbConnection");
		dbConnection4.openConnection();
		dbConnection4.closeConnection();
		configurableApplicationContext.close();
		//*d�rd�nc�y�ntemsonu
		
		
		
	}

}
