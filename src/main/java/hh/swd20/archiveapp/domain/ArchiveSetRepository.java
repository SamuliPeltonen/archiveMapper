package hh.swd20.archiveapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArchiveSetRepository extends CrudRepository<ArchiveSet, Long> {
	//method to find an ArchiveSet based on "whereStored" -attribute
	public List<ArchiveSet> findByWhereStored(String whereStored);
	//method to find an ArchiveSet based on "whatDocuments" -attribute
	public List<ArchiveSet> findByWhatDocuments(String whatDocuments);
	//method to find an ArchiveSet based on "Company" -attribute
	public List<ArchiveSet> findByCompany(Company company);
}
