package com.prijilevschi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "practice")
public class Practice extends AbstractEntity {
	@Column(name = "nm_sets")
	private Long numberSets;
	@Column(name = "nm_repeats")
	private Long numberRepeats;
	@Column(name = "nm_weight")
	private Long numberWeight;
	@Column(name = "nm_pause_time")
	private Long numberPauseTime;
	
	@ManyToOne
	@JoinColumn(name = "exercise_id")
	private Exercise exercise;
	@ManyToOne
	@JoinColumn(name = "training_id")
	private Training training;
	
	public Long getNumberSets() {
		return numberSets;
	}
	public void setNumberSets(Long numberSets) {
		this.numberSets = numberSets;
	}
	public Long getNumberRepeats() {
		return numberRepeats;
	}
	public void setNumberRepeats(Long numberRepeats) {
		this.numberRepeats = numberRepeats;
	}
	public Long getNumberWeight() {
		return numberWeight;
	}
	public void setNumberWeight(Long numberWeight) {
		this.numberWeight = numberWeight;
	}
	public Long getNumberPauseTime() {
		return numberPauseTime;
	}
	public void setNumberPauseTime(Long numberPauseTime) {
		this.numberPauseTime = numberPauseTime;
	}
	public Exercise getExercise() {
		return exercise;
	}
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	
	
}
