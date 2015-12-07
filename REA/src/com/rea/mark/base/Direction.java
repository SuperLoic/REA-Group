package com.rea.mark.base;

public enum Direction {
	NORTH(0, "NORTH"), SOUTH(180, "SOUTH"), EAST(90, "EAST"), WEST(270, "WEST");
	private Direction(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getDegree() {
		return value;
	}

	public String getDescription() {
		return desc;
	}

	public static Direction getDirection(int value) {
		Direction[] values = Direction.values();
		// set default direction to be NORTH
		Direction currentDirection = Direction.NORTH;
		for (Direction direction : values) {
			if (direction.getDegree() == value) {
				currentDirection = direction;
				break;
			}
		}
		return currentDirection;
	}

	private int value;
	private String desc;
}
