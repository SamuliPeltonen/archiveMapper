package hh.swd20.archiveapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long>{
	//method to find company based on "companyName"
	public List<Company> findByCompanyName(String companyName);

}
