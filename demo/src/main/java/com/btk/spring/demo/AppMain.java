package com.btk.spring.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;
@SpringBootApplication
public class AppMain implements CommandLineRunner{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SpringApplication.run(AppMain.class);
		System.out.println("Hello world");
		//ApplicationContext appContext;
											}
	
@Autowired
CustomerRepository customerRepository;
//JdbcTemplate jdbcTemplate;
@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	
	Assert.notNull(customerRepository, "customerRepository sorunlu mevcut deðil");
	Assert.isTrue(customerRepository.count()==0, "Tablo boþ olmalýydý");
	
	Customer customer= customerRepository.save(new Customer("foo","bee"));
	
	System.out.println(customer.toString());
	Assert.isTrue(customer.getId().longValue()==1, "id generation hatasý!!");
	
	Customer customerFound=customerRepository.findOne(1l); //Jpa da select by id yapma komutu
	System.out.println(customerFound.toString());
	/*
	Assert.notNull(jdbcTemplate, "App-context sorunlu, jdbc template mevcut deðil");
Long rowCount=	jdbcTemplate.queryForObject("select count(*) from customers", Long.class);
System.out.println("Row count "+rowCount); 
Assert.isTrue(rowCount==4, "Problem for row count");

         CustomerRowMapper rowMapper = new CustomerRowMapper();
		List<Customer> customerList= jdbcTemplate.query("select * from customers", rowMapper);
//þimdi deðerleri ekrana basalým
for(Customer customer : customerList) {
	System.out.println(customer.toString());	
}

List<Object[]> newCustomers = new ArrayList<>();
newCustomers.add(new Object[] {"foo", "bee"});
newCustomers.add(new Object[] {"edi", "büdü"});

// Uses JdbcTemplate's batchUpdate operation to bulk load data
jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", newCustomers);

customerList= jdbcTemplate.query("select * from customers", rowMapper);

//þimdi deðerleri ekrana basalým
	for(Customer customer : customerList) {
	System.out.println(customer.toString());	
}
*/

}
}
