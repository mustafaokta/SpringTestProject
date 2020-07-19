package hello;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import hello.wsdl.FindCustomerRequest;
import hello.wsdl.FindCustomerResponse;

public class CountriesWsClient extends WebServiceGatewaySupport {

	public FindCustomerResponse findCustomer(long id) {
		FindCustomerRequest request = new FindCustomerRequest();
		request.setId(id);
		
		FindCustomerResponse response = (FindCustomerResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		
		return response;
	}

	
}
