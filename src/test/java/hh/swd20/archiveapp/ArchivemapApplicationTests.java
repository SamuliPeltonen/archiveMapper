package hh.swd20.archiveapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.archiveapp.web.ArchiveSetController;
import hh.swd20.archiveapp.web.CompanyController;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArchivemapApplicationTests {

	//contains smoke-tests for different controllers
	
	//test for ArchiveSetController
	@Autowired
	private ArchiveSetController archivesetController;
	@Test
	void contextLoadsArchivesetController() throws Exception {
		assertThat(archivesetController).isNotNull();
		
	}
	
	//test for CompanyController
	@Autowired 
	private CompanyController companyController;
	@Test
	void contextLoadsCompanyController() throws Exception {
		assertThat(companyController).isNotNull();
	}
	

}
