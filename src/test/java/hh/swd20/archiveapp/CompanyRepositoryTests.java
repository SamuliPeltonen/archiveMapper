package hh.swd20.archiveapp;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.archiveapp.domain.Company;
import hh.swd20.archiveapp.domain.CompanyRepository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepositoryTests {

	@Autowired
	private CompanyRepository companyRepository;
	
	//testing the creation of a company-entity
	@Test
	public void createCompanyTest() {
		Company company = new Company("TestCompany");
		companyRepository.save(company);
		assertThat(company.getCompanyId()).isNotNull();
	}
	
	//testing findByCompanyName-method
	@Test
	public void findCompanyByFindCompanyName() {
		Company company = new Company("TestCompany");
		companyRepository.save(company);
		List<Company> companies = companyRepository.findByCompanyName("TestCompany");
		assertThat(companies).hasSize(1);
	}
	
	//testing deletion of companies
	@Test
	public void deleteCompanyTest() {
		Company company = new Company("TestCompany");
		companyRepository.save(company);
		List<Company> companies = companyRepository.findByCompanyName("TestCompany");
		assertThat(companies).hasSize(1);
		//if size == 1, "testcompany" has been added to the repository correctly
		companyRepository.deleteById(company.getCompanyId());
		companies = companyRepository.findByCompanyName("TestCompany");
		assertThat(companies).hasSize(0);
	}

}
