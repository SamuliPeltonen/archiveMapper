package hh.swd20.archiveapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	//most annotations explained in ArchiveSet-class.
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//Defining some settings for the columns in the database, id cannot be null, neither can username,password or role
	@Column(name="id", nullable = false, unique = true)
	private Long userId;
	
	//username and id must be unique, so no duplicate users can be created
	@Column(name="username", nullable = false, unique = true)
	private String username;
	
	//password can't be unique, that would be a security risk
	@Column(name="password", nullable = false)
	private String password;
	
	//role is the users role, currently USER or ADMIN
	@Column(name="role", nullable = false)
	private String role;

	
	//getters and setters
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
	//constructor with parameters
	public User(String username, String password, String role) {
		super(); 
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	//constructor without parameters
	public User() {
		
	}
	
	
	
	
}
