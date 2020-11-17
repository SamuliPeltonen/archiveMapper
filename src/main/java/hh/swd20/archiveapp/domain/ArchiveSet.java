package hh.swd20.archiveapp.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//tells hibernate that this class is an entity
//and a db-table of it must be created
@Entity
public class ArchiveSet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private long archiveId;
	@Size(min=4, max=10)
	private String whereStored;
	@Size(min=4, max=150)
	private String whatDocuments;
	private Date whenHandled;
	

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "companyId")
	private Company company;

	
	//getters and setters
	public long getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(long archiveId) {
		this.archiveId = archiveId;
	}

	public String getWhereStored() {
		return whereStored;
	}

	public void setWhereStored(String whereStored) {
		this.whereStored = whereStored;
	}

	public String getWhatDocuments() {
		return whatDocuments;
	}

	public void setWhatDocuments(String whatDocuments) {
		this.whatDocuments = whatDocuments;
	}

	public Date getWhenHandled() {
		return whenHandled;
	}

	public void setWhenHandled(Date whenHandled) {
		this.whenHandled = whenHandled;
	}

	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	//constructor with parameters
	public ArchiveSet(String whereStored, String whatDocuments, Date whenHandled, Company company) {
		super();
		this.whereStored = whereStored;
		this.whatDocuments = whatDocuments;
		this.whenHandled = whenHandled;
		this.company = company;
	}
	//constructor with no parameters
	public ArchiveSet() {

	}
}
