package gov.btk.spring.lab04.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBean {

	@Autowired
	private SingletonBean singletonBean;
	
	@Autowired
	private PrototypeBean prototypeBean;
	
	public String getMessage() {
		return String.format("Hello there, I am a SERVICE bean. SingletonBean: [%s], PrototypeBean: [%s]", 
				singletonBean.getMessage(), 
				prototypeBean.getMessage() );
	}

	public SingletonBean getSingletonBean() {
		return singletonBean;
	}
	public void setSingletonBean(SingletonBean singletonBean) {
		this.singletonBean = singletonBean;
	}

	public PrototypeBean getPrototypeBean() {
		return prototypeBean;
	}
	public void setPrototypeBean(PrototypeBean prototypeBean) {
		this.prototypeBean = prototypeBean;
	}
	
	
}
