package gov.btk.spring.lab03.javaconfig;


public class ServiceBean {

	private SingletonBean singletonBean;
	
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
