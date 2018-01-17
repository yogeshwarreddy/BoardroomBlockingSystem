package com.accolite.au.project.boardroombooking.model;

public class Branch {
	private int id;
	private String location;

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
