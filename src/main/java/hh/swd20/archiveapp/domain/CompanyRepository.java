package hh.swd20.archiveapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long>{
	public List<Company> findByCompanyName(String companyName);

}
