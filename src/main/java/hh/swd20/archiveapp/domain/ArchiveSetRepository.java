package hh.swd20.archiveapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArchiveSetRepository extends CrudRepository<ArchiveSet, Long> {
	public List<ArchiveSet> findByWhereStored(String whereStored);
	public List<ArchiveSet> findByWhatDocuments(String whatDocuments);
	public List<ArchiveSet> findByCompany(Company company);
}
