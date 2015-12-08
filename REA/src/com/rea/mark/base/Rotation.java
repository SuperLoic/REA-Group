package com.rea.mark.base;

/**
 * Define rotate patterns for robot
 * 
 * @author Mark
 *
 */
public enum Rotation {
	LEFT(-90, "LEFT"), RIGHT(90, "RIGHT");
	private Rotation(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getDegree() {
		return value;
	}

	public String getDescription() {
		return desc;
	}

	// rotate degree
	private int value;
	// description
	private String desc;
}
