package com.accolite.au.project.boardroombooking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "Role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String role_name;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users=new HashSet<User>();

	public Role() {
		super();
	}

	public Role(String role_name) {
		super();
		this.role_name = role_name;
	}

	public Role(int id, String role_name) {
		super();
		this.id = id;
		this.role_name = role_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

}
