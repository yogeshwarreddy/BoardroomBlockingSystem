package com.accolite.au.project.boardroombooking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.JoinColumnOrFormula;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	private Set<BookingRequest> requests;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;
 
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = {
			@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USERID_FK")) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User() {
		super();
	}

	public User(String email, String firstName, String lastName, String password, Branch branch) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.branch = branch;
	}

	public User(int id, String email, String firstName, String lastName, String password, Branch branch) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.branch = branch;
	}

	public User(int id, String email, String firstName, String lastName, String password, Branch branch,
			Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.branch =branch ;
		this.roles = roles;
	}
	
	public User(int id, String email, String firstName, String lastName, String password, Set<BookingRequest> requests,
			Branch branch, Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.requests = requests;
		this.branch = branch;
		this.roles = roles;
	}

	public Set<BookingRequest> getRequests() {
		return requests;
	}

	public void setRequests(Set<BookingRequest> requests) {
		this.requests = requests;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
