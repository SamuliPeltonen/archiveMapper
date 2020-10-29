package hh.swd20.archiveapp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long companyId;
	private String companyName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	@JsonBackReference
	private List<ArchiveSet> archiveSets;

	// getters and setters

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<ArchiveSet> getArchiveSets() {
		return archiveSets;
	}

	public void setArchiveSets(List<ArchiveSet> archiveSets) {
		this.archiveSets = archiveSets;
	}

	// constuctor with parameters
	

	// constructor with no parameters
	public Company() {

	}

	public Company(String companyName) {
		super();
		this.companyName = companyName;
		
	}

}
