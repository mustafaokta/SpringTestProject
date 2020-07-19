package gov.btk.spring.lab07.webrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class CustomerRestController {

	@Autowired
	CustomerRepository customerRepository;
	
	//TODO - ???("/customer/all")
	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}

	// TODO - ???("/customer/{id}")
	public Customer findById(// TODO Long id) {
		Customer customer = customerRepository.findOne(id);
		if (customer == null)
			throw new RuntimeException("I can not find a customer with id : " + id);
		
		return customer;
	}
	
}
