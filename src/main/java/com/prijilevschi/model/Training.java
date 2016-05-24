package com.prijilevschi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "training")
public class Training extends AbstractEntity {
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "training_date")
	private Date date;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "training")
	private Set<Practice> practice;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<Practice> getPractice() {
		return practice;
	}
	public void setPractice(Set<Practice> practice) {
		this.practice = practice;
	}
	
	
}
