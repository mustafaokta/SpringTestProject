package gov.btk.spring.lab05.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

@SpringBootApplication
public class AppMain implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppMain.class);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		long count = jdbcTemplate.queryForObject("select count(*) from customers", Long.class);
		System.out.println("Row count : " + count);
		
		Assert.isTrue(count == 4, "count problem!!!");
		
		List<Object[]> newCustomers = new ArrayList<>();
		newCustomers.add(new Object[] {"foo", "bee"});
		newCustomers.add(new Object[] {"edi", "büdü"});
		
        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", newCustomers);
        
		count = jdbcTemplate.queryForObject("select count(*) from customers", Long.class);
		System.out.println("Row count : " + count);
		
		Assert.isTrue(count == 6, "count problem!!!");

		List<Customer> customers = null; // TODO - query customer objects from table
		for (Customer customer : customers) {
			System.out.println(customer.getId() + " : " + customer.getFirstName() + ", " + customer.getLastName());
		}
		
	}
}
