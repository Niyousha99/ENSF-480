package model;

public class User {
	private String email;
	private String name;
	
	public User(String n) {name = n;}
	
	public void setEmail(String e) {email = e;}
	
	public String getName() {return name;}
	
	public String getEmail() {return email;}
}
