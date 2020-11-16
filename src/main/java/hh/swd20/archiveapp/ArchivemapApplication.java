package hh.swd20.archiveapp;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.archiveapp.domain.ArchiveSet;
import hh.swd20.archiveapp.domain.ArchiveSetRepository;
import hh.swd20.archiveapp.domain.Company;
import hh.swd20.archiveapp.domain.CompanyRepository;
import hh.swd20.archiveapp.domain.User;
import hh.swd20.archiveapp.domain.UserRepository;

@SpringBootApplication
public class ArchivemapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchivemapApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(CompanyRepository companyRepository, ArchiveSetRepository archiveSetRepository, UserRepository userRepository) {
		return (args) -> {
			
			
			
			Company company1 = new Company("Jarkon kalapaja");
			Company company2 = new Company("Erkan työkalu");
			companyRepository.save(company1);
			companyRepository.save(company2);
			
			//saving some test users
			User user1 = new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
					userRepository.save(user1);
					userRepository.save(user2);
		
		};
	}
}
		
	

