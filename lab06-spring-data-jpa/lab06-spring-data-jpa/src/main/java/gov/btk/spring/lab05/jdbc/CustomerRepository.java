package gov.btk.spring.lab05.jdbc;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	// List<Customer> find all by id less than a value

	// List<Customer> find all by first name field

	// List<Customer> find all by last name like parameter value

	// custom query : select c from Customer c where c.lastName = ?
	public List<Customer> findAllByCustomQuery(String lastName);
}
