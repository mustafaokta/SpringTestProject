package gov.btk.spring.lab05.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

@SpringBootApplication
public class AppMain implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppMain.class);
	}

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Count : " + customerRepository.count());
		Assert.isTrue(customerRepository.count() == 0, "table should be empty");
	
		customerRepository.save(new Customer(null, "foo", "bee"));
		customerRepository.save(new Customer(null, "foo", "baa"));
		customerRepository.save(new Customer(null, "edü", "büdü"));
		customerRepository.save(new Customer(null, "tom", "jerry"));
		
		System.out.println("Count : " + customerRepository.count());
		Assert.isTrue(customerRepository.count() == 4, "table should have 4 rows");

		// find by ID less than
		System.out.println("\n\nQuery by ID less than 3");
		List<Customer> customersByIdLessThan = customerRepository.findAllByIdLessThan(3l);
		for (Customer customer : customersByIdLessThan) {
			System.out.println(customer.toString());
		}
		
		System.out.println("Customer count : " + customersByIdLessThan.size());
		Assert.isTrue(customersByIdLessThan.size() == 2, "query should return 2 customers");
		
		// find by first name
		System.out.println("\n\nQuery by FirstName = foo");
		List<Customer> customersByFirstName = customerRepository.findAllByFirstName("foo");
		for (Customer customer : customersByFirstName) {
			System.out.println(customer.toString());
		}
		
		System.out.println("Customer count : " + customersByFirstName.size());
		Assert.isTrue(customersByFirstName.size() == 2, "query should return 2 customers");
		
		// find by custom query
		System.out.println("\n\nQuery by custom query, last name = bee");
		List<Customer> customersByLastName = customerRepository.findAllByCustomQuery("bee");
		for (Customer customer : customersByLastName) {
			System.out.println(customer.toString());
		}
		
		System.out.println("Customer count : " + customersByLastName.size());
		Assert.isTrue(customersByLastName.size() == 1, "query should return 1 customers");

		// find by last name like query
		System.out.println("\n\nQuery by custom query, last name = bee");
		List<Customer> customersByLastNameLike = customerRepository.findAllByLastNameLike("b%");
		for (Customer customer : customersByLastNameLike) {
			System.out.println(customer.toString());
		}
		
		System.out.println("Customer count : " + customersByLastNameLike.size());
		Assert.isTrue(customersByLastNameLike.size() == 3, "query should return 3 customers");
	}
}
