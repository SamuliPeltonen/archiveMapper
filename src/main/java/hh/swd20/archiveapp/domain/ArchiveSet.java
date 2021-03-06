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
	//@size is used for validation purposes, 
	@Size(min=1, max=30)
	//whereStored indicates a storing location for the documents, it could be whatever you want,
	//i.e. "between couch cushions", or something more organized.
	private String whereStored;
	@Size(min=1, max=150)
	//whatDocuments indicates the subject of storage, i.e. "The TV Remote"
	private String whatDocuments;
	//whenHandled is the exact time the Entity is created, to differentiate between similar items of the same company
	private Date whenHandled;
	
	//relationship between the company-table
	@ManyToOne
	//prevents infinite loops in json between ArchiveSet and Company
	@JsonManagedReference
	//indicates which column we want to join in the Company table
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
