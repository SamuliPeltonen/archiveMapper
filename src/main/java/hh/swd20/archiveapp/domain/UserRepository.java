package hh.swd20.archiveapp.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.support.DefaultCrudMethods;

public interface UserRepository extends CrudRepository<User, Long> {
	//method to find User by username
	User findByUsername(String username);

}
