package com.prijilevschi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@AttributeOverride(name = "name", column = @Column(name = "username"))
public class User extends AbstractNamedEntity {
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
