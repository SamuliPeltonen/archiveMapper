package hh.swd20.archiveapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
			
			Random rand = new Random();
			List<Company> companies = new ArrayList<Company>();
			
			companies.add(new Company("Jarkon kalapaja"));
			companies.add(new Company("Henkan haitarikauppa"));
			companies.add(new Company("Sarin susikoirakennel"));
			companies.add(new Company("Ravintola reilut hinnat"));
			companies.add(new Company("Pilailupuoti jekutus"));
			companies.add(new Company("Eräliike hiertymä"));
			companies.add(new Company("Eläinkauppa best pet"));
			companies.add(new Company("LVI huonot polvet"));
			companies.add(new Company("Sähköliike tukka pystyssä"));
			
			
			for (int i = 0; i < companies.size(); i++) {
				companyRepository.save(companies.get(i));
				
			}
			
			for (int i = 0; i < 160; i++) {
				archiveSetRepository.save(new ArchiveSet("L"+ rand.nextInt(10) + "P" + rand.nextInt(100), "lasku " + rand.nextInt(10000), new Date(System.currentTimeMillis()), companies.get(rand.nextInt(9))));
				
			}
			
//			Company company2 = new Company("Erkan työkalu");
//			Company company3 = new Company("Henkan haitarikauppa");
//			Company company4 = new Company("Sarin susikoirakennel");
//			Company company5 = new Company("Ravintola reilut hinnat");
//			Company company6 = new Company("Pilailupuoti jekutus");
//			Company company7 = new Company("Eräliike hiertymä");
//			Company company8 = new Company("Eläinkauppa best pet");
//			Company company9 = new Company("LVI huonot polvet");
//			Company company10 = new Company("Sähköliike tukka pystyssä");
//			
//			
//			
//			companyRepository.save(company1);
//			companyRepository.save(company2);
			
			//saving some test users
			User user1 = new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
					userRepository.save(user1);
					userRepository.save(user2);
		
		};
	}
}
		
	

