package com.prijilevschi.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exercise")
public class Exercise extends AbstractNamedEntity {
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exercise")
	private Set<Practice> practice;

	public Set<Practice> getPrograms() {
		return practice;
	}

	public void setPrograms(Set<Practice> practice) {
		this.practice = practice;
	}

	
}
