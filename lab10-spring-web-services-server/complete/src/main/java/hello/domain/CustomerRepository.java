package hello.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public List<Customer> findAllByIdLessThan(Long id);
	
	public List<Customer> findAllByFirstName(String firstName);

	public List<Customer> findAllByLastNameLike(String lastNameLike);
	
	@Query(value="select c from Customer c where c.lastName = ?")
	public List<Customer> findAllByCustomQuery(String lastName);
}
