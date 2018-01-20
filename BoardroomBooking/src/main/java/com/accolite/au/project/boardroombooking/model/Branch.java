package com.accolite.au.project.boardroombooking.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Branch")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String location;
	
	@JsonIgnore
	@OneToMany(mappedBy = "branch", fetch=FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL }) // if i delete branch all users must be deleted
	private Set<User> users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "branch", fetch=FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL }) // if i delete branch all board rooms should be deleted
	private Set<BoardRoom> boardRooms;

	public Branch() {
		super();
	}

	public Branch(String location) {
		super();
		this.location = location;
	}

	public Branch(int id, String location) {
		super();
		this.id = id;
		this.location = location;
	}

	public Branch(int id, String location, Set<User> users) {
		super();
		this.id = id;
		this.location = location;
		this.users = users;
	}

	public Branch(int id, String location, Set<User> users, Set<BoardRoom> boardRooms) {
		super();
		this.id = id;
		this.location = location;
		this.users = users;
		this.boardRooms = boardRooms;
	}

	
	public Set<BoardRoom> getBoardRooms() {
		return boardRooms;
	}

	public void setBoardRooms(Set<BoardRoom> boardRooms) {
		this.boardRooms = boardRooms;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
