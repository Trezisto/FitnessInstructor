package com.prijilevschi.model.json;

public class Exercise {
	private String name;
	private String imagePath;
	private Long sets;
	private Long repeats;
	private Long pauseTime;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Long getSets() {
		return sets;
	}
	public void setSets(Long sets) {
		this.sets = sets;
	}
	public Long getRepeats() {
		return repeats;
	}
	public void setRepeats(Long repeats) {
		this.repeats = repeats;
	}
	public Long getPauseTime() {
		return pauseTime;
	}
	public void setPauseTime(Long pauseTime) {
		this.pauseTime = pauseTime;
	}
}
