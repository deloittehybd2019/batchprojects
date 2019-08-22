package com.ems.model;

public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String email_id;
	private String password;
	private String name;
	private String country;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public User(String email_id, String password, String name, String country) {
		this.email_id = email_id;
		this.password = password;
		this.name = name;
		this.country = country;
	}
	@Override
	public String toString() {
		return "User [email_id=" + email_id + ", password=" + password + ", name=" + name + ", country=" + country
				+ "]";
	}
	@Override
	public int hashCode() {
		
		return id ;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null||!(obj instanceof User ))
			return false;
		User u=(User)obj;
		return u.id==id;
	
	}

}
