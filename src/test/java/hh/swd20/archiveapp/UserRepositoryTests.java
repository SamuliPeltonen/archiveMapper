package hh.swd20.archiveapp;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.archiveapp.domain.User;
import hh.swd20.archiveapp.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	//tests the creation of a new user
	public void createUserTest() {
		User user = new User("testUserName","testPassword", "USER");
		userRepository.save(user);
		assertThat(user.getUserId()).isNotNull();	
	}
	
	@Test
	//tests whether UserRepository's findByUsername-method finds a saved user
	public void findByUserNameShouldReturnUser() {
		User user = new User("testUserName", "testPassword", "USER");
		userRepository.save(user);
		
		assertThat(userRepository.findByUsername("testUserName")).isNotNull();
		
	}
	
	@Test
	//tests if an user is successfully deleted from the repo
	public void deleteUserTest() {
		User user = new User("testUserName", "testPassword", "USER");
		userRepository.save(user);
		//tests whether the user is added to the database first
		assertThat(userRepository.findByUsername("testUserName")).isEqualTo(user);
		//tests user's deletion after that
		userRepository.delete(user);
		assertThat(userRepository.findByUsername("testUserName")).isNull();
	}
	
}
