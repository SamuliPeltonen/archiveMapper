package hh.swd20.archiveapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.archiveapp.domain.ArchiveSet;
import hh.swd20.archiveapp.domain.ArchiveSetRepository;
import hh.swd20.archiveapp.web.ArchiveSetController;
import hh.swd20.archiveapp.web.CompanyController;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArchiveSetRepositoryTests {
	
	@Autowired
	private ArchiveSetRepository archiveSetRepository;
	
	//tests whether an archiveset is created or not
	@Test
	public void createArchiveSetTest() {
		ArchiveSet archiveSet = new ArchiveSet("test1", "test2", new Date(System.currentTimeMillis()), null);
		archiveSetRepository.save(archiveSet);
		assertThat(archiveSet.getArchiveId()).isNotNull();
	}
	//tests whether findByWhereStored-method works
	@Test
	public void findByWhereStoredShouldReturnArchiveSet() {
		ArchiveSet archiveSet = new ArchiveSet("test1", "test2", new Date(System.currentTimeMillis()), null);
		archiveSetRepository.save(archiveSet);
		List<ArchiveSet> archiveSets = archiveSetRepository.findByWhereStored("test1");
		assertThat(archiveSets).hasSize(1);
	}
	//tests whether findByWhatDocuments-method works
	@Test
	public void findByWhatDocumentsShouldReturnArchiveSet() {
		ArchiveSet archiveSet = new ArchiveSet("test1", "test2", new Date(System.currentTimeMillis()), null);
		archiveSetRepository.save(archiveSet);
		List<ArchiveSet> archiveSets = archiveSetRepository.findByWhatDocuments("test2");
		assertThat(archiveSets).hasSize(1);
	}
	
	@Test
	public void deleteArchiveSetShouldDeleteArchiveSet() {
		ArchiveSet archiveSet = new ArchiveSet("test1", "test2", new Date(System.currentTimeMillis()), null);
		archiveSetRepository.save(archiveSet);
		List<ArchiveSet> archiveSets = archiveSetRepository.findByWhereStored("test1");
		assertThat(archiveSets).hasSize(1);; //tests if archiveset is actually in the list before deletion
		//let's delete the archiveset from the repo and see if it gets deleted
		archiveSetRepository.deleteById(archiveSets.get(0).getArchiveId());
		archiveSets = archiveSetRepository.findByWhereStored("test1");
		assertThat(archiveSets).hasSize(0);
	
	}

}
