package com.evelynsalie.usermanagement.entities;

public class User {
	private long id;
	private String firstName;
	private String lastName;
	
	public User() {
		this.id = -1;
		this.firstName = null;
		this.lastName = null;
	}
	
	public User(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}
	
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}
}