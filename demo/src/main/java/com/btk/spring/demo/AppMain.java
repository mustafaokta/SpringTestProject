package com.btk.spring.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
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
JdbcTemplate jdbcTemplate;
@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	Assert.notNull(jdbcTemplate, "App-context sorunlu, jdbc template mevcut deðil");
Long rowCount=	jdbcTemplate.queryForObject("select count(*) from customers", Long.class);
System.out.println("Row count "+rowCount); 
Assert.isTrue(rowCount==4, "Problem for row count");

         List<Customer> customerList= jdbcTemplate.query("select * from customers", new RowMapper<Customer>() {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name") );
	}	
});
//þimdi deðerleri ekrana basalým
for(Customer customer : customerList) {
	System.out.println(customer.toString());
	
}

}
}
