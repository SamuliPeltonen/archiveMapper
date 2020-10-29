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

@SpringBootApplication
public class ArchivemapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchivemapApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(CompanyRepository companyRepository, ArchiveSetRepository archiveSetRepository) {
		return (args) -> {
			
			
			
			Company company1 = new Company("Stadium Helsinki");
			Company company2 = new Company("Stockmann Helsinki");
			companyRepository.save(company1);
			companyRepository.save(company2);
			
			ArchiveSet archiveSet1 = new ArchiveSet("V19H03M2","Kauppakirja, Osakekirja, Panttikirja", new Date(System.currentTimeMillis()),company1);
			archiveSetRepository.save(archiveSet1);
		
		};
	}
}
		
	

