
package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hello.wsdl.Customer;
import hello.wsdl.FindCustomerResponse;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(CountriesWsClient countriesWsClient) {
		return args -> {
			FindCustomerResponse response = countriesWsClient.findCustomer(1l);
			for (Customer customer : response.getCustomer())
				System.out.printf("%d - %s - %s\n\n", customer.getId(), customer.getFirstName(), customer.getLastName());
		};
	}

}
