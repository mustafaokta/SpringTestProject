package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import hello.domain.Customer;
import hello.domain.CustomerRepository;
import io.spring.guides.gs_producing_web_service.FindCustomerRequest;
import io.spring.guides.gs_producing_web_service.FindCustomerResponse;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private CountryRepository countryRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "findCustomerRequest")
	@ResponsePayload
	public FindCustomerResponse getCountry(@RequestPayload FindCustomerRequest request) {
		FindCustomerResponse response = new FindCustomerResponse();
		
		Customer customer = customerRepository.findOne(request.getId());
		
		io.spring.guides.gs_producing_web_service.Customer xmlCustomer = new io.spring.guides.gs_producing_web_service.Customer();
		xmlCustomer.setId(customer.getId());
		xmlCustomer.setFirstName(customer.getFirstName());
		xmlCustomer.setLastName(customer.getLastName());

		response.getCustomer().add(xmlCustomer);
		
		return response;
	}
	
}
