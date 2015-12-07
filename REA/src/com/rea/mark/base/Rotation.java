package com.rea.mark.base;

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

	private int value;
	private String desc;
}
