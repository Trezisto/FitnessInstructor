package com.prijilevschi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import com.prijilevschi.enums.UserRole;

@Entity
@Table(name = "user")
@AttributeOverride(name = "name", column = @Column(name = "username", unique = true))
public class User extends AbstractNamedEntity {
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "user_role")
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@Column(name = "is_enabled")
	private Boolean isEnabled;
	
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
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
}
