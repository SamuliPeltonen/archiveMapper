package hh.swd20.archiveapp.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.support.DefaultCrudMethods;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

}
