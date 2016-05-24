package com.prijilevschi.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Training> trainings; 
	
	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private User trainer;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer")
	private Set<User> users;
	
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
	public Set<Training> getTrainings() {
		return trainings;
	}
	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}
	public User getTrainer() {
		return trainer;
	}
	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
