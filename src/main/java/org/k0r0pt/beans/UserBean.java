package org.k0r0pt.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.k0r0pt.entities.User;

public class UserBean {
	private String username;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String password;
	private List<String> roles;

	public UserBean() {
		super();
	}

	public UserBean(User user) {
		this.username = user.getUsername();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.phoneNumber = user.getPhoneNumber();
		this.email = user.getEmail();
		this.password = user.getPassword();
		if ((user.getRoles() != null) && (user.getRoles().contains(","))) {
			this.roles = Arrays.asList(user.getRoles().split(","));
		}
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return this.roles;
	}

	public void addRole(String role) {
		if (this.roles == null) {
			roles = new ArrayList<>();
		}
		roles.add(role);
	}

	public User getEntity() {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhoneNumber(phoneNumber);
		user.setPassword(password);
		if (this.roles != null) {
			String roles = "";
			for (String role : this.roles) {
				roles.concat(role);
				roles.concat(",");
			}
			user.setRoles(roles);
		}

		return user;
	}
}
