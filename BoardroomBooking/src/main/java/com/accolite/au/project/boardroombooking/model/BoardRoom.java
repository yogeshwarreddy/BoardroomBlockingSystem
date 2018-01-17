package com.accolite.au.project.boardroombooking.model;

public class BoardRoom {
	private int id;
	private Branch branch;
	private String name;
	private int capacity;

	public BoardRoom() {
		super();
	}

	public BoardRoom(Branch branch, String name, int capacity) {
		super();
		this.branch = branch;
		this.name = name;
		this.capacity = capacity;
	}

	public BoardRoom(int id, Branch branch, String name, int capacity) {
		super();
		this.id = id;
		this.branch = branch;
		this.name = name;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
